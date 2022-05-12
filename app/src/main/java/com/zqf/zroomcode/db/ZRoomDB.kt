package com.zqf.zroomcode.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zqf.zroomcode.dao.UserDao
import com.zqf.zroomcode.entity.User

/**
 * Author: zqf
 * Date: 2022/05/11
 * 数据库创建
 * entities: 实体类
 * version: 数据库初始版本号
 * exportSchema: 是否允许数据库架构将导出到给定的文件夹中【 默认true 】
 * TODO
 *  注意：Room 在 2.4.0-alpha01 及更高版本中支持自动迁移。如果您的应用使用的是较低版本的 Room，则必须手动定义迁移。
 *
 */
@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class ZRoomDB : RoomDatabase() {

    //创建userDao
    abstract fun userDao(): UserDao
}