package com.parse.starter;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseException;
import com.parse.ParseUser;

public class ParseApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize Crash Reporting.
    ParseCrashReporting.enable(this);

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
      Parse.initialize(this, "X7EjCv6exvJ2qqnvuPawrWtIx20LYgYFPDuNuLXo", "Cbndj7YT3209HHudfmfdCsTexp8rg2So6qOXpbnD");

      try {
          ParseUser.logIn("test","test");
      } catch (ParseException e) {
          e.printStackTrace();
      }
      //ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    defaultACL.setPublicWriteAccess(true);
    // Optionally enable public read access.
    defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);

  }
}
