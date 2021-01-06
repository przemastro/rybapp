package com.rybapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class FisheryDetails : Activity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fishery_details)

        val context = this
        val db = DatabaseHelper(context)

        val titleText = findViewById<TextView>(R.id.fisheryDetails)
        val species = findViewById<TextView>(R.id.fisherySpecies)
        val area = findViewById<TextView>(R.id.fisheryArea)
        val length = findViewById<TextView>(R.id.fisheryLength)
        val width = findViewById<TextView>(R.id.fisheryWidth)
        val avgDepth = findViewById<TextView>(R.id.fisheryAvgDepth)
        val maxDepth = findViewById<TextView>(R.id.fisheryMaxDepth)
        val record = findViewById<TextView>(R.id.fisheryRecord)
        //val favoriteIcon = rowView.findViewById(R.id.favoriteIcon) as ImageView
        val imageView = findViewById<ImageView>(R.id.fisheryImageDetails)

        titleText.text = intent.getStringExtra("fishery")
        titleText.setBackgroundColor(Color.parseColor("#0C74AE"))
        titleText.setPadding(0,0,0,0)
        titleText.setTextColor(Color.WHITE)
        Log.d("fisheryDetails: ", intent.getStringExtra("fishery").toString())
        val listWithDetails = db?.getFisheryDetails(intent.getStringExtra("fishery").toString())

        species.text = listWithDetails[0]
        species.setTextColor(Color.WHITE)

        area.text = listWithDetails[1]
        area.setTextColor(Color.WHITE)

        length.text = listWithDetails[2]
        length.setTextColor(Color.WHITE)

        width.text = listWithDetails[3]
        width.setTextColor(Color.WHITE)

        avgDepth.text = listWithDetails[4]
        avgDepth.setTextColor(Color.WHITE)

        maxDepth.text = listWithDetails[5]
        maxDepth.setTextColor(Color.WHITE)

        record.text = listWithDetails[6]
        record.setTextColor(Color.WHITE)

        val resID = context.resources.getIdentifier((titleText.text.toString()),"drawable",context.packageName)
        imageView.setImageResource(resID) //define new image for imageView
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@FisheryDetails, MainActivity::class.java)
            startActivity(i)
        }
    }
}