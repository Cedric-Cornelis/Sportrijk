package be.vives.citroentjes.sportrijk.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import be.vives.citroentjes.sportrijk.model.Person;
import be.vives.citroentjes.sportrijk.model.Sport;

/**
 * Created by Jorre on 14/11/2014. en Ik :D
 */
public class DBAdapter {
    static final String KEY_PERSON_ID = "pID";
    static final String KEY_PERSON_NAME = "pName";
    static final String KEY_PERSON_SURNAME = "pSurName";
    static final String KEY_PERSON_BIRTHDATE = "pBirthdate";
    static final String KEY_PERSON_SEX = "pSex";
    static final String KEY_PERSON_LEVEL = "pLevel";
    static final String KEY_PERSON_USERNAME = "pUsername";
    static final String KEY_PERSON_PASSWORD = "pPassword";
    static final String KEY_PERSON_EMAIL = "pEmail";

    static final String KEY_FRIEND_ID = "fID";
    static final String KEY_FRIEND_PERSONID = "fPersonID";
    static final String KEY_FRIEND_PERSONFRIENDID = "fPersonFriendID";

    static final String KEY_ACHIEVEMENTS_ID = "aID";
    static final String KEY_ACHIEVEMENTS_TITLE = "aTitle";
    static final String KEY_ACHIEVEMENTS_DESCRIPTION = "aDescription";
    static final String KEY_ACHIEVEMENTS_CONDITION = "aCondition";
    static final String KEY_ACHIEVEMENTS_SPORTID = "aSportID";

    static final String KEY_EARNEDACHIEVEMENTS_ID = "eaID";
    static final String KEY_EARNEDACHIEVEMENTS_PERSONID = "eaPersonID";
    static final String KEY_EARNEDACHIEVEMENT_ACHIEVEMENTID = "eaAchievementID";

    static final String KEY_SPORT_SPORTID = "sID";
    static final String KEY_SPORT_SPORTNAME = "sName";

    static final String KEY_SPORTLOCATION_ID = "slID";
    static final String KEY_SPORTLOCATION_SPORTID = "slSportID";
    static final String KEY_SPORTLOCATION_LOCATIONID = "slLocatieID";

    static final String KEY_LOCATION_ID = "lID";
    static final String KEY_LOCATION_ADDRESS = "lAddress";
    static final String KEY_LOCATION_CITY = "lCity";
    static final String KEY_LOCATION_LONGITUDE = "lLong";
    static final String KEY_LOCATION_LATITUDE = "lLat";
    static final String KEY_LOCATION_OPENDATAID = "lOpenDataID";
    static final String KEY_LOCATION_TIMEUPDATE = "lTimeUpdate";

    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "DB_SPORTRIJK";
    static final String DATABASE_TABLE_PERSON = "Person";
    static final String DATABASE_TABLE_FRIEND = "Friend";
    static final String DATABASE_TABLE_ACHIEVEMENTS = "Achievements";
    static final String DATABASE_TABLE_EARNEDACHIEVEMENTS = "EarnedAchievements";
    static final String DATABASE_TABLE_SPORT = "Sport";
    static final String DATABASE_TABLE_SPORTLOCATION = "SportLocation";
    static final String DATABASE_TABLE_LOCATION = "Location";

    static final int DATABASE_VERSION = 1;

    static final String DATABASE_CREATE_TABLE_PERSON =
            "CREATE TABLE " + DATABASE_TABLE_PERSON +
                    "( " + KEY_PERSON_ID + " integer primary key autoincrement, " +
                    KEY_PERSON_NAME + " text not null, " +
                    KEY_PERSON_SURNAME + " text not null, " +
                    KEY_PERSON_BIRTHDATE + " text not null, " +
                    KEY_PERSON_SEX + " text not null, " +
                    KEY_PERSON_LEVEL + " text not null, " +
                    KEY_PERSON_USERNAME + " text not null, " +
                    KEY_PERSON_PASSWORD + " text not null, " +
                    KEY_PERSON_EMAIL + " text not null);";

    static final String DATABASE_CREATE_TABLE_FRIEND =
            "CREATE TABLE " + DATABASE_TABLE_FRIEND +
                    "( " + KEY_FRIEND_ID + " integer primary key autoincrement, " +
                    "FOREIGN KEY(" + KEY_FRIEND_PERSONID + ") REFERENCES " + DATABASE_TABLE_PERSON + "(" + KEY_PERSON_ID + "), " +
                    "FOREIGN KEY(" + KEY_FRIEND_PERSONFRIENDID + ") REFERENCES " + DATABASE_TABLE_PERSON + "(" + KEY_PERSON_ID + "));";

    static final String DATABASE_CREATE_TABLE_ACHIEVEMENTS =
            "CREATE TABLE " + DATABASE_TABLE_ACHIEVEMENTS +
                    "( " + KEY_ACHIEVEMENTS_ID + " integer primary key autoincrement, " +
                    KEY_ACHIEVEMENTS_TITLE + " text not null, " +
                    KEY_ACHIEVEMENTS_DESCRIPTION + " text not null, " +
                    KEY_ACHIEVEMENTS_CONDITION + " text not null, " +
                    "FOREIGN KEY(" + KEY_ACHIEVEMENTS_SPORTID + ") REFERENCES " + DATABASE_TABLE_SPORT + "(" + KEY_SPORT_SPORTID + "));";

    static final String DATABASE_CREATE_TABLE_EARNEDACHIEVEMENTS =
            "CREATE TABLE " + DATABASE_TABLE_EARNEDACHIEVEMENTS +
                    "( " + KEY_EARNEDACHIEVEMENTS_ID + " integer primary key autoincrement, " +
                    "FOREIGN KEY(" + KEY_EARNEDACHIEVEMENTS_PERSONID + ") REFERENCES " + DATABASE_TABLE_PERSON + "(" + KEY_PERSON_ID + "), " +
                    "FOREIGN KEY(" + KEY_EARNEDACHIEVEMENT_ACHIEVEMENTID + ") REFERENCES " + DATABASE_TABLE_ACHIEVEMENTS + "(" + KEY_ACHIEVEMENTS_ID + "));";

    static final String DATABASE_CREATE_TABLE_SPORT =
            "CREATE TABLE " + DATABASE_TABLE_SPORT +
                    "( " + KEY_SPORT_SPORTID + " integer primary key autoincrement, " +
                    KEY_SPORT_SPORTNAME + " text not null);";

    static final String DATABASE_CREATE_TABLE_SPORTLOCATION =
            "CREATE TABLE " + DATABASE_TABLE_SPORTLOCATION +
                    "( " + KEY_SPORTLOCATION_ID + " integer primary key autoincrement, " +
                    "FOREIGN KEY(" + KEY_SPORTLOCATION_SPORTID + ") REFERENCES " + DATABASE_TABLE_SPORT + "(" + KEY_SPORT_SPORTID + "), " +
                    "FOREIGN KEY(" + KEY_SPORTLOCATION_LOCATIONID + ") REFERENCES " + DATABASE_TABLE_LOCATION + "(" + KEY_LOCATION_ID + "));";

    static final String DATABASE_CREATE_TABLE_LOCATION =
            "CREATE TABLE " + DATABASE_TABLE_LOCATION +
                    "( " + KEY_LOCATION_ID + " integer primary key autoincrement, " +
                    KEY_LOCATION_ADDRESS + " text not null, " +
                    KEY_LOCATION_CITY+ " text not null, " +
                    KEY_LOCATION_LONGITUDE + " real not null, " +
                    KEY_LOCATION_LATITUDE + " real not null, " +
                    KEY_LOCATION_OPENDATAID + "integer null, " +
                    KEY_LOCATION_TIMEUPDATE + "integer null);";

    static final String DATABASE_DROP_TABLE = "DROP TABLE IF EXISTS ";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    
    public static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try
            {
                db.execSQL(DATABASE_CREATE_TABLE_PERSON);
                db.execSQL(DATABASE_CREATE_TABLE_FRIEND);
                db.execSQL(DATABASE_CREATE_TABLE_ACHIEVEMENTS);
                db.execSQL(DATABASE_CREATE_TABLE_EARNEDACHIEVEMENTS);
                db.execSQL(DATABASE_CREATE_TABLE_SPORT);
                db.execSQL(DATABASE_CREATE_TABLE_LOCATION);
                db.execSQL(DATABASE_CREATE_TABLE_SPORTLOCATION);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL(DATABASE_DROP_TABLE + DATABASE_TABLE_PERSON);
            db.execSQL(DATABASE_DROP_TABLE + DATABASE_TABLE_FRIEND);
            db.execSQL(DATABASE_DROP_TABLE + DATABASE_TABLE_ACHIEVEMENTS);
            db.execSQL(DATABASE_DROP_TABLE + DATABASE_TABLE_EARNEDACHIEVEMENTS);
            db.execSQL(DATABASE_DROP_TABLE + DATABASE_TABLE_SPORT);
            db.execSQL(DATABASE_DROP_TABLE + DATABASE_TABLE_LOCATION);
            db.execSQL(DATABASE_DROP_TABLE + DATABASE_TABLE_SPORTLOCATION);
        }
    }

    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }
}
