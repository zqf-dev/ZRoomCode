package com.zqf.zroomcode.ui

import android.os.Bundle
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
    }

    private fun query() {
        val list: MutableList<User> = userDao.queryAllUser()
        if (list.size > 0) {
            userAdapter.setList(list)
        } else {
            showTip("空的空的...")
        }
    }

    private fun insert() {
        runBlocking {
            for (a in 1..10) {
                val user = User(
                    "张三$a",
                    20 + a,
                    "贵阳市观山湖去区$a",
                    "https://img1.baidu.com/it/u=2838359103,4082675852&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500"
                )
                userDao.addUser(user)
            }
            query()
        }
    }

    private fun delete() {
        runBlocking {
            userDao.deleteUser()
        }
    }


    private fun showTip(tip: String) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show()
    }
}