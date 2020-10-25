package com.rybapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView

/**
 * Created by Przemek on 24.10.2020.
 */
class List : Activity() {
    var textViewNumero: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)
    }

    companion object {
        var idValue: String? = null
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@List, MainActivity::class.java)
            startActivity(i)
        }
    }
}