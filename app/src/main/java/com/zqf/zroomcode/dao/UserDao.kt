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

    //根据姓名参数查询
    @Query("SELECT * FROM loginUser WHERE name = :name")
    fun queryFindUser(name: String): User?

    // 添加单条数据
    @Insert
    fun addUser(vararg user: User)

    // 添加批量数据
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBatchUser(list: MutableList<User>)

    // 更新某一个数据
    @Update
    fun updateUser(vararg user: User)

    //更新所有数据
    @Query("UPDATE loginUser set age='50'")
    fun updateAll()

    //删除某一个数据
    @Delete
    fun deleteSingle(vararg user: User)

    //删除表里所有数据
    @Query("DELETE FROM loginUser")
    fun deleteAllUser()
}