package be.vives.citroentjes.sportrijk;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import be.vives.citroentjes.sportrijk.database.DBAdapter;
import be.vives.citroentjes.sportrijk.interfaces.OnFragmentInteractionListener;
import be.vives.citroentjes.sportrijk.model.Person;


public class LoginFragment extends Fragment
{
    private OnFragmentInteractionListener mListener;
    private View view;
    private EditText txtUsername;
    private EditText txtPassword;
    private Person person;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);
        Button btnLogin = (Button) view.findViewById(R.id.btnLogin);
        Button btnRegistreer =(Button) view.findViewById(R.id.btnRegistreer);

        txtUsername = (EditText) view.findViewById(R.id.txtUsername);
        txtPassword = (EditText) view.findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(btnLoginClicked);
        btnRegistreer.setOnClickListener(btnRegistreerClicked);
        return view;
    }

    private View.OnClickListener btnLoginClicked = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (mListener != null)
            {
                if(1==1/*!txtUsername.getText().equals(null)&&!txtPassword.getText().equals(null)*/)
                {
                    DBAdapter db = new DBAdapter(getActivity().getBaseContext());

                    Person person = db.getPerson(txtUsername.toString());

                    if(1==1/*person != null*/)
                    {
                        if(1==1/*person.getPassword().equals(txtPassword.toString())*/)
                        {
                            mListener.showNextFragment(0);
                        }
                    }
                }
                else
                {
                    Toast.makeText(getActivity().getBaseContext(), "Password incorrect", Toast.LENGTH_LONG).show();
                    txtPassword.setText("");
                }
            }
            else
            {
                Toast.makeText(getActivity().getBaseContext(), "Logingegevens invullen", Toast.LENGTH_LONG).show();
            }
        }
    };


    private View.OnClickListener btnRegistreerClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {

                mListener.showNextFragment(5);
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
