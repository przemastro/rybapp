package com.rybapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.collections.List


/**
 * Created by Przemek on 24.10.2020.
 */
class Map : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map2) as SupportMapFragment
        mapFragment.getMapAsync(this)
        supportActionBar?.hide()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMapReady(googleMap: GoogleMap) {
        val context = this
        val db = DatabaseHelper(context)
        db.insertFishery()
        mMap = googleMap

        val list = db.getFishery()
        val name = list[0]
        val lat: List<Double> = list[1].map(String::toDouble)
        val lng = list[2].map(String::toDouble)

        for (i in 0 until name.size) {
            Log.d(lat[i].toString(),lng[i].toString())
            val latLng = LatLng(lat[i],lng[i])
            mMap.addMarker(MarkerOptions().position(latLng).title(name[i]))
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(51.98,19.48)))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(6.0f));
        var toast: Toast
        var imageView = ImageView(this)

        mMap.setOnMarkerClickListener { marker ->
            Log.d("title",marker.title)
            val resID =
                resources.getIdentifier(marker.title, "drawable", packageName)
            Log.d("map2: ", resID.toString())
            imageView.setImageResource(resID); //define new image for imageView

            toast = Toast(context)
            val layout = layoutInflater.inflate(R.layout.custom_toast_layout,
            toast.view?.parent as? ViewGroup?)
            toast.view = layout //update toast with custom layout
            imageView = toast.view?.findViewById(R.id.customToast)!! //update imageView

            toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
            toast.duration = Toast.LENGTH_LONG

            toast.show()

            false
        }
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@Map, MainActivity::class.java)
            startActivity(i)
        }
    }

}

