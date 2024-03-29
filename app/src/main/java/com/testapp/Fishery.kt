package com.testapp

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

/**
 * Created by Przemek on 24.10.2020.
 */
class Fishery : Activity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fishery)

        val context = this
        val db = DatabaseHelper(context)

        val list = db.getFavorites()
        val fishery = list[0]
        val description = list[1]

        val favoritesAdapter = MyFavoritesAdapter(this,fishery,description)
        var listView = findViewById<ListView>(R.id.favoritesListView)
        listView.adapter = favoritesAdapter


        listView.onItemClickListener = AdapterView.OnItemClickListener { favoritesAdapter, view, position, id ->
            val itemIdAtPos = favoritesAdapter.getItemIdAtPosition(position)
            val name = favoritesAdapter.getItemAtPosition(itemIdAtPos.toInt())

            //val itemLink = links[itemIdAtPos.toInt()]

            val intent = Intent(this, FisheryDetails::class.java)
            intent.putExtra("fishery", name.toString())
            startActivity(intent)
        }
    }


    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@Fishery, MainActivity::class.java)
            startActivity(i)
        }
    }
}