package org.michenux.yourappidea.home;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * @author Mohammed Boukadir  @:mohammed.boukadir@gmail.com
 *
 */
@Module
public class YourAppMainActivityModule {

    private Activity activity;

    YourAppMainActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity activity() {
        return activity;
    }
}
