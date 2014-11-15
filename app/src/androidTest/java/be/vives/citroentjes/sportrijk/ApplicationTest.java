package be.vives.citroentjes.sportrijk;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.Date;

import be.vives.citroentjes.sportrijk.database.DBAdapter;
import be.vives.citroentjes.sportrijk.enums.Gender;
import be.vives.citroentjes.sportrijk.enums.Level;
import be.vives.citroentjes.sportrijk.model.Person;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}