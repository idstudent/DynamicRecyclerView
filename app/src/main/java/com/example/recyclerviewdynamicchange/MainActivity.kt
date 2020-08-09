package com.example.recyclerviewdynamicchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter : Adapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = ArrayList<Int>()

        for(i in 1 until 4) {
            itemList.add(i)
        }

        if(itemList.size in 4..5) {
            val gridLayoutManager = GridLayoutManager(this, 2)
            recyclerView.layoutManager = gridLayoutManager
            if(itemList.size %2 == 1) {
                adapter = Adapter(this, itemList, 1)
                changeList(itemList)
            }else{
                adapter = Adapter(this, itemList, 0)
                changeList(itemList)
            }

        }else if(itemList.size > 5){
            val gridLayoutManager = GridLayoutManager(this, 3)
            recyclerView.layoutManager = gridLayoutManager
            changeList(itemList)
        }else {
            val gridLayoutManager = GridLayoutManager(this, 2)
            recyclerView.layoutManager = gridLayoutManager
            changeList(itemList)
        }

        recyclerView.adapter = adapter
    }
    private fun changeList(itemList : ArrayList<Int>) {
        if(itemList.size %2 == 1) {
            adapter = Adapter(this, itemList, 1)
        }else{
            adapter = Adapter(this, itemList, 0)
        }

    }
}
