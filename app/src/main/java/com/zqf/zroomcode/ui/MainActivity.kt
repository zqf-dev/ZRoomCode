package com.zqf.zroomcode.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drake.net.Get
import com.drake.net.utils.scopeNetLife
import com.zqf.zroomcode.R
import com.zqf.zroomcode.dao.UserDao
import com.zqf.zroomcode.entity.ChannelEntity
import com.zqf.zroomcode.entity.User
import com.zqf.zroomcode.ui.adapter.UserAdapter
import com.zqf.zroomcode.utils.DbManager
import com.zqf.zroomcode.utils.HmConverter
import com.zqf.zroomcode.utils.ToastUtil
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val TagL = MainActivity::class.java.simpleName
    private lateinit var net: Button
    private lateinit var queryBtn: Button
    private lateinit var insertBtn: Button
    private lateinit var updateBtn: Button
    private lateinit var deleteBtn: Button
    private lateinit var resultRecycle: RecyclerView
    private var list = mutableListOf<User>()
    var userDao: UserDao = DbManager.db.userDao()

    private val userAdapter by lazy {
        UserAdapter(R.layout.user_item_layout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findVbId()
    }

    private fun findVbId() {
        net = findViewById(R.id.net)
        queryBtn = findViewById(R.id.query)
        insertBtn = findViewById(R.id.insert)
        updateBtn = findViewById(R.id.update)
        deleteBtn = findViewById(R.id.delete)
        resultRecycle = findViewById(R.id.result_recycle)
        resultRecycle.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        resultRecycle.adapter = userAdapter
        userAdapter.addChildClickViewIds(R.id.item_delete, R.id.item_modify)
        net.setOnClickListener { startActivity(Intent(this, NetFrameActivity::class.java)) }
        queryBtn.setOnClickListener { query() }
        insertBtn.setOnClickListener { insertSingle() }
        deleteBtn.setOnClickListener { delete() }
        updateBtn.setOnClickListener { update() }
        userAdapter.setOnItemChildClickListener { _, view, position ->
            when (view.id) {
                R.id.item_delete -> singleDel(list[position])
                R.id.item_modify -> singleModify(list[position])
            }
        }
        insertAll()
    }

    /**
     * ??????
     */
    private fun query() {
        list = userDao.queryAllUser()
        Log.e(TagL, list.toString())
        userAdapter.setList(list)
    }

    /**
     * ????????????????????????
     */
    private fun insertAll() {
        runBlocking {
            if (userDao.queryAllUser().size == 0) {
                val mutableList: MutableList<User> = mutableListOf()
                for (a in 1..3) {
                    val user = User("??????$a", 20 + a, "?????????????????????$a", "")
                    mutableList.add(user)
                }
                userDao.addBatchUser(mutableList)
                ToastUtil.show("????????????????????????")
            }
            query()
        }
    }

    /**
     * ??????????????????
     */
    private fun insertSingle() {
        val age = Random.nextInt(20, 40)
        val user = User("??????", age, "?????????????????????", "")
        userDao.addUser(user)
        ToastUtil.show("????????????????????????")
        query()
    }

    /**
     * ???????????????????????????
     */
    private fun delete() {
        userDao.deleteAllUser()
        ToastUtil.show("????????????????????????")
        query()
    }

    /**
     * ??????????????????
     */
    private fun update() {
        userDao.updateAll()
        ToastUtil.show("????????????????????????????????????")
        query()
    }

    /**
     * ??????loginUser??????????????????????????????
     */
    private fun singleDel(singleUser: User) {
        userDao.deleteSingle(singleUser)
        ToastUtil.show("????????????????????????")
        query()
    }

    /**
     * ?????????????????????????????????????????????
     */
    private fun singleModify(user: User) {
        user.aliasName = "?????????" + user.aliasName
        user.age = 100
        user.ads = "????????????????????????"
        userDao.updateUser(user)
        ToastUtil.show("????????????????????????")
        list.clear()
        query()
    }
}
