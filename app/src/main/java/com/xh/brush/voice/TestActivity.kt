package com.xh.brush.voice

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xh.brush.voice.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Desc:
 * Company: xuehai
 * Copyright: Copyright (c) 2020
 *
 * @author xhdjh
 * @since 2020/12/11 21/18
 */
class TestActivity : AppCompatActivity() {

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)

        myAdapter = MyAdapter(mutableListOf())
        recyclerView.adapter = myAdapter

        initData()
    }

    private fun initData() {
        val dataList = mutableListOf<Int>()
        for (index in 0..100) {
            dataList.add(index)
        }
        myAdapter.mDataList = dataList
    }
}