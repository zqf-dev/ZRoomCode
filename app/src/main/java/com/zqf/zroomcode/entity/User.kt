package com.zqf.zroomcode.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Author: zqf
 * Date: 2022/05/11
 * 数据实体
 * TODO
 *  1、PrimaryKey: 主键（ autoGenerate = true 主键自增 ），作用：唯一标识相应数据库表中的每一行
 *  2、@ColumnInfo：默认情况下，Room 将【类名称】用作数据库【表名称】，使用【字段名称】作为数据库中的【列名称】
 *  注：如果您希望表具有不同的名称，请设置 @Entity 注解的 tableName 属性
 *     如果您希望列具有不同的名称，请将 @ColumnInfo 注解添加到该字段并设置 name 属性
 *  3、Ignore: 默认情况下，Room 会为实体中定义的每个字段创建一个列。 如果您不想保留该字段，则可以使用 @Ignore 为字段添加注解
 */
@Entity(tableName = "loginUser")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "name")
    var aliasName: String = "",
    var age: Int = 0,
    var ads: String = "",
    @Ignore
    var avatar: String = ""
) {
    constructor(aliasName: String, age: Int, ads: String, avatar: String) : this() {
        this.aliasName = aliasName
        this.age = age
        this.ads = ads
        this.avatar = avatar
    }

    override fun toString(): String {
        return "User(id=$id, aliasName='$aliasName', age=$age, ads='$ads', avatar='$avatar')"
    }
}
