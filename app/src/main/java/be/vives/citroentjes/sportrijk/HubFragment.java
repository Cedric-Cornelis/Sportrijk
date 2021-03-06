package be.vives.citroentjes.sportrijk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import be.vives.citroentjes.sportrijk.interfaces.OnFragmentInteractionListener;


public class HubFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private View view;

    public HubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_hub, container, false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);
        Button btnStartRoute=(Button) view.findViewById(R.id.btnStartRoute);
        btnStartRoute.setOnClickListener(btnStartRouteClicked);
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


    private View.OnClickListener btnStartRouteClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.showNextFragment(1);
            }
        }
    };


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
