package com.rybapp

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import java.time.LocalDate

val DATABASE_NAME = "RybappDB"
val TABLE_NAME_EVENTS = "EVENTS"
val TABLE_NAME_FISHERY = "FISHERY"

class DatabaseHelper(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 4) {

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db?.execSQL("create table " + TABLE_NAME_EVENTS + " (ID INTEGER, EVENT TEXT, EVENT_DATE TEXT, LINK TEXT);");
            db?.execSQL("create table " + TABLE_NAME_FISHERY + " (ID INTEGER, FISHERY TEXT, LAT TEXT, LNG TEXT);");
        } catch (e: SQLException) {
            print(e)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun insertEvents() {
        val today = LocalDate.now() //Today

        val db = this.writableDatabase
        db?.execSQL("DELETE FROM " + TABLE_NAME_EVENTS);
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('1','Otwarte mistrzostwa Polski w spinningu na rzece Nysa Kłodzka','"+ today.plusDays(1).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('2','Pierwszy krajowy konkurs spławikowy w Wieluniu. Zawody odbędą się w formule \"1 spławik, 1  żyłka \"','"+ today.plusDays(8).toString()+"', 'http://www.pzw.org.pl/jeleniagora/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('3','Kobiecy turniej wędkarski \"Złoty Karp\" - Osowa Góra','"+ today.plusDays(12).toString()+"', 'http://www.poznan.pzw.org.pl/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('4','Mazurski wielki połów grubego leszcza. Zawody potrwają do 20 Grudnia 2021','"+ today.plusDays(14).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('5','Dziesiątka Wielkopolska - turniej otwarty. Kategoria wiekowa 60+','"+ today.plusDays(18).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('6','Bałtyckie Dorsze i Flondry','"+ today.plusDays(19).toString()+"', 'http://www.pzw.org.pl/jeleniagora/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('7','Mistrzostwa spinningowe - rzeka San','"+ today.plusDays(24).toString()+"', 'http://www.poznan.pzw.org.pl/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('8','Bałtyckie Dorsze i Flondry - druga edycja','"+ today.plusDays(25).toString()+"', 'http://www.poznan.pzw.org.pl/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('9','Złota Flondra','"+ today.plusDays(28).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('10','Mistrzostwa spinningowe - rzeka Wisła','"+ today.plusDays(31).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('11','Górski pogrom','"+ today.plusDays(38).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('12','Śląskie płotki','"+ today.plusDays(42).toString()+"', 'http://www.poznan.pzw.org.pl/');");
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertFishery() {
        val today = LocalDate.now() //Today

        val db = this.writableDatabase
        db?.execSQL("DELETE FROM " + TABLE_NAME_FISHERY);
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('1','kierskie','52.46', '16.78');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('2','niepruszewskie','52.37', '16.61');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('3','dabie','53.75', '14.46');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('4','jamno','54.27', '16.15');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('5','jeziorsko','51.82', '18.69');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('6','kornickie','52.24', '17.08');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('7','lebsko','54.71', '17.39');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('8','niegocin','54.00', '21.77');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('9','zbaszynskie','52.23', '15.90');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('10','powidzkie','52.41', '17.93');");
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('11','sniardwy','53.75', '21.72');");
    }

    fun getEvents(): MutableList<String> {
        val list: MutableList<String> = ArrayList()
        val db = this.readableDatabase
        val query = "select EVENT from " + TABLE_NAME_EVENTS
        val res = db.rawQuery(query, null)
        var event: String
        res.moveToFirst()
        if (res.moveToFirst()) {
            do {
                event = res.getString(res.getColumnIndex("EVENT"))
                list.add(event)
            }
            while (res.moveToNext())
        }
        return list
    }

    fun getDates(): MutableList<String> {
        val list: MutableList<String> = ArrayList()
        val db = this.readableDatabase
        val query = "select EVENT_DATE from " + TABLE_NAME_EVENTS
        val res = db.rawQuery(query, null)
        var eventDate: String
        res.moveToFirst()
        if (res.moveToFirst()) {
            do {
                eventDate = res.getString(res.getColumnIndex("EVENT_DATE"))
                list.add(eventDate)
            }
            while (res.moveToNext())
        }
        return list
    }

    fun getLinks(): MutableList<String> {
        val list: MutableList<String> = ArrayList()
        val db = this.readableDatabase
        val query = "select LINK from " + TABLE_NAME_EVENTS
        val res = db.rawQuery(query, null)
        var eventLink: String
        res.moveToFirst()
        if (res.moveToFirst()) {
            do {
                eventLink = res.getString(res.getColumnIndex("LINK"))
                list.add(eventLink)
            }
            while (res.moveToNext())
        }
        return list
    }

    fun getFishery(): Array<MutableList<String>> {
        val list: MutableList<String> = ArrayList()
        val list2: MutableList<String> = ArrayList()
        val list3: MutableList<String> = ArrayList()
        val db = this.readableDatabase
        val query = "select FISHERY, LAT, LNG from $TABLE_NAME_FISHERY"
        val res = db.rawQuery(query, null)
        var fishery: String
        var lat: String
        var lng: String
        res.moveToFirst()
        if (res.moveToFirst()) {
            do {
                fishery = res.getString(res.getColumnIndex("FISHERY"))
                lat = res.getString(res.getColumnIndex("LAT"))
                lng = res.getString(res.getColumnIndex("LNG"))
                list.add(fishery)
                list2.add(lat)
                list3.add(lng)
            }
            while (res.moveToNext())
        }
        return arrayOf(
            list,
            list2,
            list3
        )
    }
}