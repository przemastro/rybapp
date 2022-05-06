package com.testapp

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyFishingAdapter (private val context: Activity,
                        private val fish: MutableList<String>,
                        private val weight: MutableList<String>,
                        private val fishery: MutableList<String>,
                        private val fishingDate: MutableList<String>)
    : ArrayAdapter<String>(context, R.layout.custom_list3, fishery) {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list3, null, true)

        val fishElement = rowView.findViewById(R.id.fishElement) as TextView
        val weightElement = rowView.findViewById(R.id.weightElement) as TextView
        val fisheryElement = rowView.findViewById(R.id.fisheryElement) as TextView
        val fishingDateElement = rowView.findViewById(R.id.fishingDateElement) as TextView

        fishElement.text = fish[position]
        weightElement.text = weight[position]
        fisheryElement.text = fishery[position]
        fishingDateElement.text = fishingDate[position]

        fishElement.setTextColor(Color.WHITE)
        fishElement.setPadding(10,0,10,0)

        weightElement.setTextColor(Color.WHITE)
        weightElement.setPadding(10,0,10,0)

        fisheryElement.setTextColor(Color.WHITE)
        fisheryElement.setPadding(10,0,10,0)

        fishingDateElement.setTextColor(Color.WHITE)
        fishingDateElement.setPadding(10,0,10,0)

        return rowView
    }
}