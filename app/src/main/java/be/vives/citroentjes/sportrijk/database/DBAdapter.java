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
 * Created by Jorre on 14/11/2014.
 */
public class DBAdapter {
    static final String KEY_PERSOON_PERSOONID = "pID";
    static final String KEY_PERSOON_PERSOONNAAM = "pNaam";
    static final String KEY_PERSOON_PERSOONVOORNAAM = "pVoornaam";
    static final String KEY_PERSOON_PERSOONGEBOORTEDATUM = "pGebDatum";
    static final String KEY_PERSOON_PERSOONGESLACHT = "pGeslacht";
    static final String KEY_PERSOON_PERSOONNIVEAU = "pNiveau";
    static final String KEY_PERSOON_PERSOONGEBRUIKERSNAAM = "pGebruikersnaam";
    static final String KEY_PERSOON_PERSOONWACHTWOORD = "pWachtwoord";

    static final String KEY_VRIEND_VRIENDID = "vID";
    static final String KEY_VRIEND_VRIENDPERSOONID = "vPersoonID";
    static final String KEY_VRIEND_VRIENDVRIENDID = "vVriendID";

    static final String KEY_ACHIEVEMENTS_ACHIEVEMENTID = "aID";
    static final String KEY_ACHIEVEMENTS_ACHIEVEMENTTITEL = "aTitel";
    static final String KEY_ACHIEVEMENTS_ACHIEVEMENTOMSCHRIJVING = "aOmschrijving";
    static final String KEY_ACHIEVEMENTS_ACHIEVEMENTVOORWAARDE = "aVoorwaarde";
    static final String KEY_ACHIEVEMENTS_ACHIEVEMENTSPORTID = "aSportID";

    static final String KEY_BEHAALDEACHIEVEMENTS_BEHAALDEACHIEVEMENT_ID = "baID";
    static final String KEY_BEHAALDEACHIEVEMENTS_BEHAALDEACHIEVEMENT_PERSOONID = "baPersoonID";
    static final String KEY_BEHAALDEACHIEVEMENTS_BEHAALDEACHIEVEMENT_ACHIEVEMENTID = "baAchievementID";

    static final String KEY_SPORT_SPORTID = "sID";
    static final String KEY_SPORT_SPORTNAAM = "sNaam";

    static final String KEY_SPORTPERLOCATIE_SPORTPERLOCATIEID = "splID";
    static final String KEY_SPORTPERLOCATIE_SPORTPERLOCATIE_SPORTID = "splSportID";
    static final String KEY_SPORTPERLOCATIE_SPORTPERLOCATIE_LOCATIEID = "splLocatieID";

    static final String KEY_LOCATIE_LOCATIEID = "lID";
    static final String KEY_LOCATIE_LOCATIEADRES = "lAdres";
    static final String KEY_LOCATIE_LOCATIEGEMEENTE = "lGemeente";
    static final String KEY_LOCATIE_LOCATIELONGITUDE = "lLong";
    static final String KEY_LOCATIE_LOCATIELATITUDE = "lLat";
    static final String KEY_LOCATIE_LOCATIEOPENDATAID = "lOpenDataID";
    static final String KEY_LOCATIE_LOCATIETIMEUPDATE = "lTimeUpdate";

    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "DB_SPORTRIJK";
}
