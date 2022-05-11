package com.zqf.zroomcode.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zqf.zroomcode.app.App
import com.zqf.zroomcode.dao.UserDao
import com.zqf.zroomcode.entity.User

/**
 * Author: zqf
 * Date: 2022/05/11
 * 数据库创建
 * entities: 实体类
 * version: 数据库初始版本号
 * exportSchema: 是否允许数据库架构将导出到给定的文件夹中【 默认true 】
 *
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class ZRoomDB : RoomDatabase() {

    //创建userDao
    abstract fun userDao(): UserDao
}