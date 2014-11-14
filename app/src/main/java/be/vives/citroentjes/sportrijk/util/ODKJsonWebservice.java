package be.vives.citroentjes.sportrijk.util;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import be.vives.citroentjes.sportrijk.interfaces.ODKJson;
import be.vives.citroentjes.sportrijk.model.Sport;

/**
 * Created by Ik on 14/11/2014.
 */
public class ODKJsonWebservice extends AsyncTask<ODKJson, Void, JSONObject>
{
    ODKJson listener;

    JSONArray sportLijst;
    ArrayList<Sport> sporten;

    @Override
    protected JSONObject doInBackground(ODKJson... params)
    {
        listener = params[0];

        StringBuilder sportenBuilder = new StringBuilder();

        HttpClient sportenClient = new DefaultHttpClient();

        try
        {
            HttpGet sportenGet = new HttpGet("http://data.drk.be/kortrijk/sport_outdoorlocaties.json");

            HttpResponse sportenResponse = sportenClient.execute(sportenGet);
            StatusLine sportenSearchStatus = sportenResponse.getStatusLine();

            if(sportenSearchStatus.getStatusCode() == 200)
            {
                HttpEntity sportenEntity = sportenResponse.getEntity();
                InputStream placesContent = sportenEntity.getContent();
                InputStreamReader placesInput = new InputStreamReader(placesContent);
                BufferedReader placesReader = new BufferedReader(placesInput);

                String lineIn;

                while((lineIn = placesReader.readLine()) != null)
                {
                    sportenBuilder.append(lineIn);
                }

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        JSONObject jsonObject;

        try
        {
            jsonObject = new JSONObject(sportenBuilder.toString());
        }
        catch(Exception e)
        {
            jsonObject = null;
        }

        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject json)
    {
        Sport sportObject;

        try
        {
            sportLijst = json.getJSONArray("sport_outdoorlocaties");
            sporten = new ArrayList<Sport>();

            for(int i = 0; i < sportLijst.length(); i++)
            {
                JSONObject jsonObject = sportLijst.getJSONObject(i);

                String adres = jsonObject.getString("adres");
                String gemeente = jsonObject.getString("gemeente");
                String soort = jsonObject.getString("soort");
                String sport = jsonObject.getString("sport");
                double longitude = jsonObject.getDouble("long");
                double latitude = jsonObject.getDouble("lat");

                //kot = new Kot(straat, huisnummer, gemeente, kamers, longitude, latitude);
                sportObject = new Sport(adres, gemeente, soort, sport, longitude, latitude);

                sporten.add(sportObject);
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        listener.updateArray(sporten);
    }
}
