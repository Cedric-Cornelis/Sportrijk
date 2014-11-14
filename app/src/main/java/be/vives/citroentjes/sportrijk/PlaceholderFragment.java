package be.vives.citroentjes.sportrijk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.vives.citroentjes.sportrijk.interfaces.ODKJson;

import be.vives.citroentjes.sportrijk.model.Sport;

import be.vives.citroentjes.sportrijk.util.ODKJsonWebservice;

import java.util.ArrayList;

/**
 * Created by Ik on 14/11/2014.
 */
public class PlaceholderFragment extends Fragment implements ODKJson
{
    private View rootView;
    private ArrayList<Sport> sportList;

    public PlaceholderFragment()
    {
        ODKJsonWebservice webservice = new ODKJsonWebservice();
        webservice.execute(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //some code here

        return rootView;
    }

    @Override
    public void updateArray(ArrayList<Sport> array)
    {
        this.sportList = array;
    }
}
