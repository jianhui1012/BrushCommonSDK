package com.xh.brush.voice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.xh.brush.voice.adapter.FlexAdapter
import kotlinx.android.synthetic.main.activity_flex_ui.*

/**
 * Desc:
 * Company: xuehai
 * Copyright: Copyright (c) 2021
 *
 * @author xhdjh
 * @since 2021/02/19 18/08
 */
class FlexUIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataList = mutableListOf<Int>()
        for (i in 1..100) {
            dataList.add(i)
        }
        val flexBoxLayoutManager = FlexboxLayoutManager(this)
        flexBoxLayoutManager.flexDirection = FlexDirection.ROW
        flexBoxLayoutManager.flexWrap = FlexWrap.WRAP
        flexBoxLayoutManager.justifyContent = JustifyContent.CENTER
        recyclerView.layoutManager = flexBoxLayoutManager
        recyclerView.adapter = FlexAdapter(dataList)
    }

}