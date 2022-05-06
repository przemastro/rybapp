package com.testapp

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
val TABLE_NAME_FAVORITES = "FAVORITES"
val TABLE_NAME_USERS = "USERS"
val TABLE_NAME_FISHING = "FISHING"

class DatabaseHelper(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 4) {

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db?.execSQL("create table " + TABLE_NAME_EVENTS + " (ID INTEGER, EVENT TEXT, EVENT_DATE TEXT, LINK TEXT);")
            db?.execSQL("create table " + TABLE_NAME_FISHERY + " (ID INTEGER, FISHERY TEXT, LAT TEXT, LNG TEXT, DESCRIPTION TEXT, SPECIES TEXT, AREA TEXT, LENGTH TEXT, WIDTH TEXT, AVG_DEPTH TEXT, MAX_DEPTH TEXT, RECORD TEXT);")
            db?.execSQL("create table " + TABLE_NAME_FAVORITES + " (ID INTEGER, USERS_ID INTEGER, FISHERY_ID INTEGER);")
            db?.execSQL("create table " + TABLE_NAME_USERS + " (ID INTEGER, LOGIN TEXT);")
            db?.execSQL("create table " + TABLE_NAME_FISHING + " (ID INTEGER, FISH TEXT, WEIGHT TEXT, FISHERY_ID INTEGER, FISHING_DATE TEXT, USERS_ID INTEGER, STATUS TEXT);")
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
        db?.execSQL("DELETE FROM " + TABLE_NAME_EVENTS)
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('1','4Developers - The largest interdisciplinary technology festival for programmers in Poland','"+ today.plusDays(1).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('2','DżawaLovers - The only place where you can feel like at home','"+ today.plusDays(8).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('3','DevOps4Ever - Place not defined yet','"+ today.plusDays(12).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('4','To Code or Not to Code Conference - Warsaw','"+ today.plusDays(14).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('5','QA SpaceTime - Cracow','"+ today.plusDays(18).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('6','Baltic IT Heroes for recruiters - Gdańsk','"+ today.plusDays(19).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('7','Cracow IT Days','"+ today.plusDays(24).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('8','Bug or Feature - biggest QA conference in Poland','"+ today.plusDays(25).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('9','The golden member of IT festival','"+ today.plusDays(28).toString()+"', 'https://www.miquido.com/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('10','PHP is dead - the final conference of PHP developers','"+ today.plusDays(31).toString()+"', 'https://www.miquido.com/');")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertFishery() {
        val db = this.writableDatabase
        db?.execSQL("DELETE FROM " + TABLE_NAME_FISHERY)
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('1','krakow','50.06', '19.94', 'The biggest and the only true capital of IT in Poland. Loacted in the south of Poland in the large Wisła Valley a true polish silicon valley.', 'Mostly known for best QAs in Poland and few good Flutter developers.', 'Area 9851,0 - 10282,4 ha', '- max length 40 km', '- max width 32 km', 'average 9,8k PLN', 'max 43k PLN', 'In the summer of 2019 a fistfull of amazing java developers was recruited.');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('2','warsaw','52.22', '21.01', 'A little city, close to the russian border, best known for PHP and Fortran developers', 'PHP developers. Some Cobol developers available', 'Area 961,0 - 9282,4 ha', '- max length 10 km', '- max width 9 km', 'average 5,8k PLN', 'max 15k PLN', 'In the winter of 2020 one React developer has been recruited');")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertFavorites() {
        val db = this.writableDatabase
        db?.execSQL("DELETE FROM " + TABLE_NAME_FAVORITES)
        db?.execSQL("insert into " + TABLE_NAME_FAVORITES + " values ('1','1', '1');")
        db?.execSQL("insert into " + TABLE_NAME_FAVORITES + " values ('2','1', '2');")

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertUsers() {
        val db = this.writableDatabase
        db?.execSQL("DELETE FROM " + TABLE_NAME_USERS)
        db?.execSQL("insert into " + TABLE_NAME_USERS + " values ('1','pjag');")
        db?.execSQL("insert into " + TABLE_NAME_USERS + " values ('2','tkastr');")

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertFishing() {
        val db = this.writableDatabase
        db?.execSQL("DELETE FROM " + TABLE_NAME_FISHING)
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('1','Dev in Test', '15k', '1', '15-01-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('2','Senior React Dev', '12k', '2', '16-01-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('3','AWS Dev', '16k', '1', '15-03-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('4','QA', '18k', '1', '26-03-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('5','Senior DevOps', '10k', '1', '25-03-2020', '1', 'OLD');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('6','Junior Flutter Dev', '8k', '1', '01-04-2020', '1', 'OLD');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('7','Java Dev', '5k', '2', '18-05-2020', '1', 'OLD');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('8','Kotlin Dev', '4k', '1', '07-06-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('9','QA', '4k', '2', '19-10-2020', '1', 'OLD');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('10','Java Dev', '15k', '1', '20-10-2020', '1', 'NEW');")
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

    fun getFavorites(): Array<MutableList<String>> {
        val list: MutableList<String> = ArrayList()
        val list2: MutableList<String> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT fi.FISHERY, fi.DESCRIPTION FROM " + TABLE_NAME_FISHERY + " as fi JOIN " + TABLE_NAME_FAVORITES + " as fa ON fi.ID=fa.FISHERY_ID WHERE fa.USERS_ID=1"
        Log.d("query: ",query)
        val res = db.rawQuery(query, null)
        var fishery: String
        var description: String
        res.moveToFirst()
        if (res.moveToFirst()) {
            do {
                fishery = res.getString(res.getColumnIndex("FISHERY"))
                description = res.getString(res.getColumnIndex("DESCRIPTION"))
                list.add(fishery)
                list2.add(description)
                Log.d("fishery: ",fishery)
            }
            while (res.moveToNext())
        }
        return arrayOf(
            list,
            list2
        )
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

    fun getFishing(status: String): Array<MutableList<String>> {
        val list: MutableList<String> = ArrayList()
        val list2: MutableList<String> = ArrayList()
        val list3: MutableList<String> = ArrayList()
        val list4: MutableList<String> = ArrayList()
        val db = this.readableDatabase
        val query =
            "select fg.FISH, fg.WEIGHT, fy.FISHERY, fg.FISHING_DATE from " + TABLE_NAME_FISHING + " as fg JOIN " + TABLE_NAME_FISHERY + " as fy ON fg.FISHERY_ID=fy.ID where STATUS='" + status + "'"
        val res = db.rawQuery(query, null)
        var fish: String
        var weight: String
        var fishery: String
        var fishingDate: String
        res.moveToFirst()
        if (res.moveToFirst()) {
            do {
                fish = res.getString(res.getColumnIndex("FISH"))
                weight = res.getString(res.getColumnIndex("WEIGHT"))
                fishery = res.getString(res.getColumnIndex("FISHERY"))
                fishingDate = res.getString(res.getColumnIndex("FISHING_DATE"))
                list.add(fish)
                list2.add(weight)
                list3.add(fishery)
                list4.add(fishingDate)
            }
            while (res.moveToNext())
        }
        return arrayOf(
            list,
            list2,
            list3,
            list4
        )
    }

    fun getFisheryDetails(fishery: String): Array<String> {
        var species: String
        var area: String
        var length: String
        var width: String
        var avgDepth: String
        var maxDepth: String
        var record: String
        val db = this.readableDatabase
        val query = "select SPECIES, AREA, LENGTH, WIDTH, AVG_DEPTH, MAX_DEPTH, RECORD from " + TABLE_NAME_FISHERY + " where FISHERY='" + fishery + "'"
        val res = db.rawQuery(query, null)
        res.moveToFirst()
        species = res.getString(res.getColumnIndex("SPECIES"))
        area = res.getString(res.getColumnIndex("AREA"))
        length = res.getString(res.getColumnIndex("LENGTH"))
        width = res.getString(res.getColumnIndex("WIDTH"))
        avgDepth = res.getString(res.getColumnIndex("AVG_DEPTH"))
        maxDepth = res.getString(res.getColumnIndex("MAX_DEPTH"))
        record = res.getString(res.getColumnIndex("RECORD"))

        return arrayOf(species, area, length, width, avgDepth, maxDepth, record)
    }
}