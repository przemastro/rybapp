package com.testapp

import android.app.Activity
import android.graphics.Color
import android.graphics.Color.WHITE
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class MyListAdapter(private val context: Activity, private val dates: MutableList<String>, private val events: MutableList<String>)
    : ArrayAdapter<String>(context, R.layout.custom_list, dates) {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById(R.id.dates) as TextView
        val subtitleText = rowView.findViewById(R.id.events) as TextView

        titleText.text = events[position]
        subtitleText.text = dates[position]

        subtitleText.setTextColor(WHITE)
        subtitleText.setBackgroundColor(Color.parseColor("#0C74AE"))
        subtitleText.layoutParams.width = 700
        subtitleText.setPadding(20,0,0,0)

        titleText.setPadding(20,0,0,0)
        titleText.setTextColor(WHITE)

        return rowView
    }

}

