package be.vives.citroentjes.sportrijk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.vives.citroentjes.sportrijk.interfaces.OnFragmentInteractionListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class SportrouteOne extends Fragment {
    private OnFragmentInteractionListener mListener;
    private View view;

    public SportrouteOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_hub, container, false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }


}
