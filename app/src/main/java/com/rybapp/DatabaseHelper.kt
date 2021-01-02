package com.rybapp

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime

val DATABASE_NAME = "RybappDB"
val TABLE_NAME = "EVENTS"

class DatabaseHelper(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 4) {

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db?.execSQL("create table " + TABLE_NAME + " (ID INTEGER, EVENT TEXT, EVENT_DATE TEXT, LINK TEXT);");
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
        db?.execSQL("DELETE FROM " + TABLE_NAME);
        db?.execSQL("insert into " + TABLE_NAME + " values ('1','Otwarte mistrzostwa Polski w spinningu na rzece Nysa Kłodzka','"+ today.plusDays(1).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('2','Pierwszy krajowy konkurs spławikowy w Wieluniu. Zawody odbędą się w formule \"1 spławik, 1  żyłka \"','"+ today.plusDays(8).toString()+"', 'http://www.pzw.org.pl/jeleniagora/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('3','Kobiecy turniej wędkarski \"Złoty Karp\" - Osowa Góra','"+ today.plusDays(12).toString()+"', 'http://www.poznan.pzw.org.pl/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('4','Mazurski wielki połów grubego leszcza. Zawody potrwają do 20 Grudnia 2021','"+ today.plusDays(14).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('5','Dziesiątka Wielkopolska - turniej otwarty. Kategoria wiekowa 60+','"+ today.plusDays(18).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('6','Bałtyckie Dorsze i Flondry','"+ today.plusDays(19).toString()+"', 'http://www.pzw.org.pl/jeleniagora/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('7','Mistrzostwa spinningowe - rzeka San','"+ today.plusDays(24).toString()+"', 'http://www.poznan.pzw.org.pl/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('8','Bałtyckie Dorsze i Flondry - druga edycja','"+ today.plusDays(25).toString()+"', 'http://www.poznan.pzw.org.pl/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('9','Złota Flondra','"+ today.plusDays(28).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('10','Mistrzostwa spinningowe - rzeka Wisła','"+ today.plusDays(31).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('11','Górski pogrom','"+ today.plusDays(38).toString()+"', 'http://www.pzw.org.pl/pzw/');");
        db?.execSQL("insert into " + TABLE_NAME + " values ('12','Śląskie płotki','"+ today.plusDays(42).toString()+"', 'http://www.poznan.pzw.org.pl/');");
    }

    fun getEvents(): MutableList<String> {
        val list: MutableList<String> = ArrayList()
        val db = this.readableDatabase
        val query = "select EVENT from " + TABLE_NAME
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
        val query = "select EVENT_DATE from " + TABLE_NAME
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
        val query = "select LINK from " + TABLE_NAME
        val res = db.rawQuery(query, null)
        var eventDate: String
        res.moveToFirst()
        if (res.moveToFirst()) {
            do {
                eventDate = res.getString(res.getColumnIndex("LINK"))
                list.add(eventDate)
            }
            while (res.moveToNext())
        }
        return list
    }
}