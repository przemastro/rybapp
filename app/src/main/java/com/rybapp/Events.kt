package com.rybapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.AdapterView
import android.widget.ListView


/**
 * Created by Przemek on 24.10.2020.
 */
class Events : Activity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events)
        val context = this
        val db = DatabaseHelper(context)

        val events = db?.getEvents()
        val dates = db?.getDates()
        val links = db?.getLinks()
        val myListAdapter = MyListAdapter(this,dates,events)
        var listView = findViewById<ListView>(R.id.listView)
        listView.adapter = myListAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            val itemLink = links[itemIdAtPos.toInt()]

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(itemLink))
            startActivity(browserIntent)
        }
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@Events, MainActivity::class.java)
            startActivity(i)
        }
    }
}


