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
import be.vives.citroentjes.sportrijk.model.Location;
import be.vives.citroentjes.sportrijk.model.Sport;

/**
 * Created by Ik on 14/11/2014.
 */
public class ODKJsonWebservice extends AsyncTask<ODKJson, Void, JSONObject>
{
    ODKJson listener;

    JSONArray locatieJsonList;
    ArrayList<Sport> sportList;
    ArrayList<Location> locationList;

    @Override
    protected JSONObject doInBackground(ODKJson... params)
    {
        listener = params[0];

        StringBuilder sportBuilder = new StringBuilder();

        HttpClient sportClient = new DefaultHttpClient();

        try
        {
            HttpGet sportGet = new HttpGet("http://data.drk.be/kortrijk/sport_outdoorlocaties.json");

            HttpResponse sportResponse = sportClient.execute(sportGet);
            StatusLine sportSearchStatus = sportResponse.getStatusLine();

            if(sportSearchStatus.getStatusCode() == 200)
            {
                HttpEntity sportEntity = sportResponse.getEntity();
                InputStream placesContent = sportEntity.getContent();
                InputStreamReader placesInput = new InputStreamReader(placesContent);
                BufferedReader placesReader = new BufferedReader(placesInput);

                String lineIn;

                while((lineIn = placesReader.readLine()) != null)
                {
                    sportBuilder.append(lineIn);
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
            jsonObject = new JSONObject(sportBuilder.toString());
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
        Location locationObject;
        Sport sportObject;

        try
        {
            locatieJsonList = json.getJSONArray("sport_outdoorlocaties");
            sportList = new ArrayList<Sport>();

            for(int i = 0; i < locatieJsonList.length(); i++)
            {
                JSONObject jsonObject = locatieJsonList.getJSONObject(i);

                String address = jsonObject.getString("adres");
                String city = jsonObject.getString("gemeente");
                String name = jsonObject.getString("sport");
                double longitude = jsonObject.getDouble("long");
                double latitude = jsonObject.getDouble("lat");

                locationObject = new Location(address, city, longitude, latitude, i+1);
                sportObject = new Sport(name,locationObject);

                sportList.add(sportObject);
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        listener.updateArray(sportList);
    }
}
