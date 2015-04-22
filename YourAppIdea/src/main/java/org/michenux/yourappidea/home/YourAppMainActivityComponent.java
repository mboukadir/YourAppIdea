package org.michenux.yourappidea.home;

import org.michenux.drodrolib.ActivityScope;
import org.michenux.yourappidea.YourAppComponent;
import org.michenux.yourappidea.facebook.FbLoginFragment;
import org.michenux.yourappidea.settings.SettingsFragment;
import org.michenux.yourappidea.tutorial.TutorialListFragment;

import dagger.Component;

/**
 * @author Mohammed Boukadir  @:mohammed.boukadir@gmail.com
 */
@ActivityScope
@Component(dependencies = {YourAppComponent.class},
        modules = YourAppMainActivityModule.class
)
public interface YourAppMainActivityComponent
        extends MainFragment.Injector, FbLoginFragment.Injector, SettingsFragment.Injector,
        TutorialListFragment.Injector, YourAppNavigationFragment.Injector{

    void injectActivity(YourAppMainActivity yourAppMainActivity);
}
