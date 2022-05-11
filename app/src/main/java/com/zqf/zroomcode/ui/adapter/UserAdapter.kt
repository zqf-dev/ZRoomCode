package com.zqf.zroomcode.ui.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zqf.zroomcode.R
import com.zqf.zroomcode.entity.User

/**
 * Author: zqf
 * Date: 2022/05/11
 */
class UserAdapter(layoutResId: Int) : BaseQuickAdapter<User, BaseViewHolder>(layoutResId) {
    override fun convert(holder: BaseViewHolder, item: User) {
        val avatarView = holder.getView<ImageView>(R.id.avatar)
        Glide.with(context).load(item.avatar)
            .transform(CircleCrop())
            .placeholder(R.mipmap.placeholder)
            .error(R.mipmap.placeholder)
            .into(avatarView)
        holder.setText(R.id.name, "姓名：${item.aliasName}")
            .setText(R.id.age, "年龄：${item.age} 岁")
            .setText(R.id.ads, "地址：${item.ads}")
    }
}