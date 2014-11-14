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


public class LoginFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private View view;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_login, container, false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);
        Button btnLogin=(Button) view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(btnLoginClicked);
        return view;
    }

    private View.OnClickListener btnLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.showNextFragment(0);
            }
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
