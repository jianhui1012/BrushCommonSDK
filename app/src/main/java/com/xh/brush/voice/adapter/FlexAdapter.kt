package com.xh.brush.voice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.xh.brush.voice.R
import kotlinx.android.synthetic.main.item_my.view.*


/**
 * Desc: 弹性布局适配器
 * Company: xuehai
 * Copyright: Copyright (c) 2020
 *
 * @author xhdjh
 * @since 2020/12/11 21/41
 */
class FlexAdapter(dataList: MutableList<Int>) : RecyclerView.Adapter<FlexAdapter.MyViewHolder>() {

     var mDataList: MutableList<Int> = dataList

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_my, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            tv_context.text = "测试${position}"
        }
    }
}