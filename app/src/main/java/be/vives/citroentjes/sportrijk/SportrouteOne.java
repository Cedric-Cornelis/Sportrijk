package be.vives.citroentjes.sportrijk;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

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
        view=inflater.inflate(R.layout.fragment_sportroute_one, container, false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        Button btnVerder=(Button) view.findViewById(R.id.btnVerder);
        btnVerder.setOnClickListener(btnVerderClicked);
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

    private View.OnClickListener btnVerderClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                RadioGroup rgGroup=(RadioGroup) view.findViewById(R.id.rgGroup);
                RadioGroup rgRoute=(RadioGroup) view.findViewById(R.id.rgRoute);
                if(rgGroup.getCheckedRadioButtonId()!=-1&&rgRoute.getCheckedRadioButtonId()!=-1) {
                    mListener.showNextFragment(2);
                }
                else
                {
                    Toast.makeText(getActivity().getBaseContext(), "Selecteer uw voorkeuren", Toast.LENGTH_LONG).show();
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
