package com.testapp

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.ListView

/**
 * Created by Przemek on 24.10.2020.
 */
class List<T> : Activity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)


        val context = this
        val db = DatabaseHelper(context)

        val listWithNew = db.getFishing("NEW")
        val listWithOld = db.getFishing("OLD")

        var fishingAdapter = MyFishingAdapter(this,listWithNew[0],listWithNew[1],listWithNew[2],listWithNew[3])
        var listViewNew = findViewById<ListView>(R.id.fishingNewListView)
        listViewNew.adapter = fishingAdapter

        fishingAdapter = MyFishingAdapter(this,listWithOld[0],listWithOld[1],listWithOld[2],listWithOld[3])
        val listViewOld = findViewById<ListView>(R.id.fishingOldListView)
        listViewOld.adapter = fishingAdapter
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@List, MainActivity::class.java)
            startActivity(i)
        }
    }
}