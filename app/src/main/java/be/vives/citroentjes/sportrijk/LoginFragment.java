package be.vives.citroentjes.sportrijk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import be.vives.citroentjes.sportrijk.enums.Gender;
import be.vives.citroentjes.sportrijk.enums.Level;
import be.vives.citroentjes.sportrijk.interfaces.OnFragmentInteractionListener;
import be.vives.citroentjes.sportrijk.model.Person;


public class LoginFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private View view;
    private EditText txtUsername;
    private EditText txtPassword;
    private Person person;

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

        txtUsername=(EditText) view.findViewById(R.id.txtUsername);
        txtPassword=(EditText) view.findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(btnLoginClicked);
        return view;
    }

    private View.OnClickListener btnLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                if(!txtUsername.getText().equals(null)&&!txtPassword.getText().equals(null))
                {
                        //person=get persoon aan de hand van username
                }
                    if(person.getUsername().equals(txtUsername.getText().toString()) && person.getPassword().equals(txtPassword.getText().toString())) {
                    mListener.showNextFragment(0);
                }
                else
                {
                    Toast.makeText(getActivity().getBaseContext(), "Password incorrect", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(getActivity().getBaseContext(), "Logingegevens invullen", Toast.LENGTH_LONG).show();
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
