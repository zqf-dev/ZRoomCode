package com.zqf.zroomcode.entity

/**
 * Author: zqf
 * Date: 2022/05/17
 */
class BannerEntity {
    private val desc: String = ""
    private val id: String = ""
    private val imagePath: String = ""
    private var isVisible: Int = 0
    private var order: Int = 0
    private val title: String = ""
    private val url: String = ""
    override fun toString(): String {
        return "BannerEntity(desc='$desc', id='$id', imagePath='$imagePath', isVisible=$isVisible, order=$order, title='$title', url='$url')"
    }
}