package be.vives.citroentjes.sportrijk;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import be.vives.citroentjes.sportrijk.interfaces.OnFragmentInteractionListener;


public class MainActivity extends ActionBarActivity implements OnFragmentInteractionListener{


    private boolean login=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            if (login == false)
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new LoginFragment())
                        .commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new HubFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //code voor de up-button
            case android.R.id.home:
                FragmentManager fm= getSupportFragmentManager();
                if(fm.getBackStackEntryCount()>0){
                    fm.popBackStack();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showNextFragment(int button) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch(button)
        {
            case 0:
                fragmentTransaction.replace(R.id.container, new HubFragment());
                login=true;
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
