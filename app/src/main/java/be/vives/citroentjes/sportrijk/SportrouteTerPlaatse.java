package be.vives.citroentjes.sportrijk;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import be.vives.citroentjes.sportrijk.interfaces.OnFragmentInteractionListener;


public class SportrouteTerPlaatse extends Fragment {
    private OnFragmentInteractionListener mListener;
    private View view;

    public SportrouteTerPlaatse() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_login, container, false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);
        Button btnNextActivity = (Button) view.findViewById(R.id.btnNextActivity);

        btnNextActivity.setOnClickListener(btnNextActivityClicked);
        return view;
    }

    private View.OnClickListener btnNextActivityClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Navigatie naar de volgende pagina - kweetnie welkeen dat is, you might know ;)
        }
    };

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
