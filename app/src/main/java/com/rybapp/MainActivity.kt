package com.rybapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.rybapp.Fishery

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val context = this
        val db = DatabaseHelper(context)
        db.insertUsers()
        db.insertFishing()
        db.insertFishery()
        db.insertEvents()
        db.insertFavorites()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.map) {
            val i = Intent(this@MainActivity, Map::class.java)
            startActivity(i)
        }

        if (v.id == R.id.fishery) {
            val i = Intent(this@MainActivity, Fishery::class.java)
            startActivity(i)
        }

        if (v.id == R.id.fishing) {
            val i = Intent(this@MainActivity, Fishing::class.java)
            startActivity(i)
        }

        if (v.id == R.id.list) {
            val i = Intent(this@MainActivity, List::class.java)
            startActivity(i)
        }

        if (v.id == R.id.events) {
            val i = Intent(this@MainActivity, Events::class.java)
            startActivity(i)
        }
    }

}