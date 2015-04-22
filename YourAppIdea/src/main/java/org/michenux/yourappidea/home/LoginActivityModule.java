package org.michenux.yourappidea.home;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * @author Mohammed Boukadir  @:mohammed.boukadir@gmail.com
 */
@Module
public class LoginActivityModule {

    private Activity activity;

    LoginActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity activity() {
        return activity;
    }

}
