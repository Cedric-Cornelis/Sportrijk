package be.vives.citroentjes.sportrijk;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

import be.vives.citroentjes.sportrijk.interfaces.OnFragmentInteractionListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateRouteTwo extends Fragment {

    private OnFragmentInteractionListener mListener;
    private View view;


    public CreateRouteTwo() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_create_route_two, container, false);
        Button btnStartRoute=(Button) view.findViewById(R.id.btnVerder2);
        btnStartRoute.setOnClickListener(btnVerder2Clicked);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private View.OnClickListener btnVerder2Clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                LinearLayout ll=(LinearLayout) view.findViewById(R.id.LLCeck);
                ArrayList<CheckBox> CheckList=new ArrayList<CheckBox>();
                for (int i=0;i<ll.getChildCount();i++)
                {
                    LinearLayout llc=(LinearLayout) ll.getChildAt(i);
                    for(int j=0;j<llc.getChildCount();j++) {
                        if (llc.getChildAt(j) instanceof CheckBox) {
                            if (((CheckBox) llc.getChildAt(j)).isChecked()) {
                                CheckList.add((CheckBox) llc.getChildAt(j));
                            }
                        }
                    }
                }
                if(CheckList.size()>0) {
                    mListener.showNextFragment(3);
                }
                else
                {
                    Toast.makeText(getActivity().getBaseContext(), "Gelieve een activiteit te kiezen", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
