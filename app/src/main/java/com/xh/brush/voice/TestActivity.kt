package com.xh.brush.voice

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
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
        val minHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300f,
                resources.displayMetrics).toInt()
        ll_scroll.minimumHeight = minHeight
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        val dm = DisplayMetrics()

        windowManager.defaultDisplay.getMetrics(dm)
        myAdapter = MyAdapter(mutableListOf())
        recyclerView.adapter = myAdapter

        initData()

        var layoutParams = ll_scroll.layoutParams as AppBarLayout.LayoutParams
        var appBarLayoutParams = appbar.layoutParams as CoordinatorLayout.LayoutParams
        btn1.setOnClickListener {
            ll_scroll.minimumHeight = minHeight
            layoutParams.scrollFlags = (AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                    or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED)
            appBarLayoutParams.behavior = AppBarLayout.Behavior()
            appbar.layoutParams = appBarLayoutParams
            recyclerView.visibility = View.GONE
            tv_head.visibility = View.GONE
        }
        btn2.setOnClickListener {
            ll_scroll.minimumHeight =2392
            layoutParams.scrollFlags = (AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                    or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED)
            appBarLayoutParams.behavior = AppBarLayout.Behavior()
            appbar.layoutParams = appBarLayoutParams
            recyclerView.visibility = View.GONE
            tv_head.visibility = View.GONE
        }
        btn3.setOnClickListener {
            ll_scroll.minimumHeight = 0
            layoutParams.scrollFlags = (AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL)
            appBarLayoutParams.behavior = AppBarLayout.Behavior()
            appbar.layoutParams = appBarLayoutParams
            recyclerView.visibility = View.VISIBLE
            tv_head.visibility = View.VISIBLE
            initData()
        }
    }

    private fun initData() {
        val dataList = mutableListOf<Int>()
        for (index in 0..20) {
            dataList.add(index)
        }
        myAdapter.mDataList = dataList
    }
}