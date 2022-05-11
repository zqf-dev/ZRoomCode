package com.zqf.zroomcode.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zqf.zroomcode.R
import com.zqf.zroomcode.dao.UserDao
import com.zqf.zroomcode.entity.User
import com.zqf.zroomcode.ui.adapter.UserAdapter
import com.zqf.zroomcode.utils.DbManager
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var queryBtn: Button
    private lateinit var insertBtn: Button
    private lateinit var updateBtn: Button
    private lateinit var deleteBtn: Button
    private lateinit var resultRecycle: RecyclerView
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
        queryBtn = findViewById(R.id.query)
        insertBtn = findViewById(R.id.insert)
        updateBtn = findViewById(R.id.update)
        deleteBtn = findViewById(R.id.delete)
        resultRecycle = findViewById(R.id.result_recycle)
        resultRecycle.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        resultRecycle.adapter = userAdapter
        queryBtn.setOnClickListener { query() }
        insertBtn.setOnClickListener { insert() }
        deleteBtn.setOnClickListener { delete() }
        updateBtn.setOnClickListener { update() }
    }

    /**
     * 查询
     */
    private fun query() {
        val list: MutableList<User> = userDao.queryAllUser()
        Log.e("TAG", list.toString())
        if (list.size > 0) {
            userAdapter.setList(list)
        } else {
            showTip("空的空的...")
        }
    }

    /**
     * 插入数据
     */
    private fun insert() {
        runBlocking {
            for (a in 1..10) {
                val user = User(
                    "张三$a",
                    20 + a,
                    "贵阳市观山湖区$a",
                    ""
                )
                userDao.addUser(user)
            }
            query()
        }
    }

    /**
     * 删除loginUser表里的所有数据【目前指定删除某一个】
     */
    private fun delete() {
        runBlocking {
            val user = userDao.queryFindUser("张三1")
            Log.e("TAG", "user: $user")
            if (user != null) {
                userDao.deleteUser(user)
            }
        }
    }

    /**
     * 更新数据
     */
    private fun update() {
        runBlocking {
            val user = userDao.queryFindUser("张三2")
            Log.e("TAG", "user: $user")
            if (user != null) {
                val id = user.id
                val newUser = User(id, "李四", user.age, user.ads, user.avatar)
                userDao.updateUser(newUser)
            }
        }
    }


    private fun showTip(tip: String) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show()
    }
}