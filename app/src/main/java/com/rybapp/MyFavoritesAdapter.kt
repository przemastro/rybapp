package com.rybapp

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.content.Context
import android.content.res.Resources

class MyFavoritesAdapter(private val context: Activity, private val fishery: MutableList<String>, private val description: MutableList<String>)
    : ArrayAdapter<String>(context, R.layout.custom_list2, fishery) {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list2, null, true)

        val titleText = rowView.findViewById(R.id.favoriteFishery) as TextView
        val subtitleText = rowView.findViewById(R.id.favoriteFisheryDescription) as TextView
        //val favoriteIcon = rowView.findViewById(R.id.favoriteIcon) as ImageView
        val imageView = rowView.findViewById(R.id.favoriteImage) as ImageView

        titleText.text = fishery[position]
        subtitleText.text = description[position]

        subtitleText.setTextColor(Color.WHITE)
        subtitleText.layoutParams.width = 700
        subtitleText.layoutParams.height = 200
        subtitleText.setPadding(15,0,0,0)

        titleText.setBackgroundColor(Color.parseColor("#0C74AE"))
        titleText.setPadding(0,0,0,0)
        titleText.setTextColor(Color.WHITE)

        //favoriteIcon.setBackgroundColor(Color.parseColor("#0C74AE"))
        //favoriteIcon.layoutParams.width = 100

        val resID = context.resources.getIdentifier((titleText.text.toString()),"drawable",context.packageName)
        imageView.setImageResource(resID) //define new image for imageView
        return rowView
    }
}