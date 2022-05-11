package com.zqf.zroomcode.dao

import androidx.room.*
import com.zqf.zroomcode.entity.User

/**
 * Author: zqf
 * Date: 2022/05/11
 * 数据访问对象
 */
@Dao
interface UserDao {
    // 查询
    @Query("SELECT * FROM loginUser")
    fun queryAllUser(): MutableList<User>

    // 添加
    @Insert
    fun addUser(vararg user: User)

    // 更新
    @Update
    fun updateUser(vararg user: User)

    //删除
    @Delete
    fun deleteUser(vararg user: User)
}