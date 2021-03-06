package com.rybapp

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import java.time.LocalDate
import kotlin.math.max

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
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('1','Otwarte mistrzostwa Polski w spinningu na rzece Nysa Kłodzka','"+ today.plusDays(1).toString()+"', 'http://www.pzw.org.pl/pzw/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('2','Pierwszy krajowy konkurs spławikowy w Wieluniu. Zawody odbędą się w formule \"1 spławik, 1  żyłka \"','"+ today.plusDays(8).toString()+"', 'http://www.pzw.org.pl/jeleniagora/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('3','Kobiecy turniej wędkarski \"Złoty Karp\" - Osowa Góra','"+ today.plusDays(12).toString()+"', 'http://www.poznan.pzw.org.pl/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('4','Mazurski wielki połów grubego leszcza. Zawody potrwają do 20 Grudnia 2021','"+ today.plusDays(14).toString()+"', 'http://www.pzw.org.pl/pzw/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('5','Dziesiątka Wielkopolska - turniej otwarty. Kategoria wiekowa 60+','"+ today.plusDays(18).toString()+"', 'http://www.pzw.org.pl/pzw/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('6','Bałtyckie Dorsze i Flondry','"+ today.plusDays(19).toString()+"', 'http://www.pzw.org.pl/jeleniagora/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('7','Mistrzostwa spinningowe - rzeka San','"+ today.plusDays(24).toString()+"', 'http://www.poznan.pzw.org.pl/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('8','Bałtyckie Dorsze i Flondry - druga edycja','"+ today.plusDays(25).toString()+"', 'http://www.poznan.pzw.org.pl/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('9','Złota Flondra','"+ today.plusDays(28).toString()+"', 'http://www.pzw.org.pl/pzw/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('10','Mistrzostwa spinningowe - rzeka Wisła','"+ today.plusDays(31).toString()+"', 'http://www.pzw.org.pl/pzw/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('11','Górski pogrom','"+ today.plusDays(38).toString()+"', 'http://www.pzw.org.pl/pzw/');")
        db?.execSQL("insert into " + TABLE_NAME_EVENTS + " values ('12','Śląskie płotki','"+ today.plusDays(42).toString()+"', 'http://www.poznan.pzw.org.pl/');")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertFishery() {
        val db = this.writableDatabase
        db?.execSQL("DELETE FROM " + TABLE_NAME_FISHERY)
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('1','kierskie','52.46', '16.78', 'Jezioro rynnowe polodowcowe, położone w zachodniej części Poznania. Jest to największy zbiornik wodny miasta i jeden z największych w Wielkopolsce. Jezioro leży na terenie Pojezierza Poznańskiego.', 'Leszcze, Karpie królewskie, Szczupaki, Sumy', 'Powierzchnia 9851,0 - 10282,4 ha', '- max długość 20 km', '- max szerokość 12 km', 'średnia 9,8 m', 'maksymalna 43,8 m', 'Karp królewski 12m. Połów wykonany w roku 1984 przez Remigusza Pospieszyńskiego w ramach kłusownictwa. Obywatel został skazany na 4 lata więzienia.');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('2','niepruszewskie','52.37', '16.61', 'Jezioro w Polsce, w województwie wielkopolskim, w powiecie poznańskim, na terenie gmin Dopiewo i Buk należące do Pojezierza Poznańskiego w dorzeczu Warty, 7 km na wschód od Buku, na wysokości 76,3 m n.p.m.', 'Leszcze, Płocie, Liny, Karasie', 'Powierzchnia 961,0 - 9282,4 ha', '- max długość 10 km', '- max szerokość 9 km', 'średnia 5,8 m', 'maksymalna 13,8 m', 'Szczupak 12m. Połów wykonany w roku 1999 przez Remigusza Pospieszyńskiego w ramach kłusownictwa. Obywatel został skazany na prace społeczne w zakładzie ubezpieczeń społecznych pod kierownictwem ministra Patkowskiego.');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('3','dabie','53.75', '14.46', '', '', '', '', '', '', '', '');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('4','jamno','54.27', '16.15', '', '', '', '', '', '', '', '');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('5','jeziorsko','51.82', '18.69', '', '', '', '', '', '', '', '');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('6','kornickie','52.24', '17.08', '', '', '', '', '', '', '', '');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('7','lebsko','54.71', '17.39', '', '', '', '', '', '', '', '');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('8','niegocin','54.00', '21.77', '', '', '', '', '', '', '', '');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('9','zbaszynskie','52.23', '15.90', '', '', '', '', '', '', '', '');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('10','powidzkie','52.41', '17.93', '', '', '', '', '', '', '', '');")
        db?.execSQL("insert into " + TABLE_NAME_FISHERY + " values ('11','sniardwy','53.75', '21.72', '', '', '', '', '', '', '', '');")
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
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('1','Karp', '15kg', '1', '15-01-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('2','Karp', '12kg', '3', '16-01-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('3','Leszcz', '1kg', '4', '15-03-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('4','Karp', '18kg', '1', '26-03-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('5','Leszcz', '10kg', '5', '25-03-2020', '1', 'OLD');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('6','Szczupak', '8kg', '7', '01-04-2020', '1', 'OLD');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('7','Sum', '5kg', '3', '18-05-2020', '1', 'OLD');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('8','Leszcz', '4kg', '3', '07-06-2020', '1', 'NEW');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('9','Płoć', '4kg', '2', '19-10-2020', '1', 'OLD');")
        db?.execSQL("insert into " + TABLE_NAME_FISHING + " values ('10','Lin', '0.5kg', '1', '20-10-2020', '1', 'NEW');")
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