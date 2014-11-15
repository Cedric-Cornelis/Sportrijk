package be.vives.citroentjes.sportrijk;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import be.vives.citroentjes.sportrijk.database.DBAdapter;
import be.vives.citroentjes.sportrijk.interfaces.OnFragmentInteractionListener;
import be.vives.citroentjes.sportrijk.model.Person;

/**
 * Created by Ik on 15/11/2014.
 */
public class RegistrationFragment extends Fragment
{
    private OnFragmentInteractionListener mListener;
    private View view;
    private Person person;

    public RegistrationFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);
        Button btnVoltooi = (Button) view.findViewById(R.id.btnVoltooien);

        btnVoltooi.setOnClickListener(btnVoltooiClicked);
        return view;
    }

    private View.OnClickListener btnVoltooiClicked = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            mListener.showNextFragment(0);
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
