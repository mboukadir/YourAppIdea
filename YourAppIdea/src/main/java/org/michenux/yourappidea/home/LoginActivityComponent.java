package org.michenux.yourappidea.home;

import org.michenux.drodrolib.ActivityScope;
import org.michenux.yourappidea.YourAppComponent;
import org.michenux.yourappidea.facebook.FbLoginFragment;

import dagger.Component;

/**
 * @author Mohammed Boukadir  @:mohammed.boukadir@gmail.com
 */
@ActivityScope
@Component(dependencies = {YourAppComponent.class},
        modules = LoginActivityModule.class
)
public interface LoginActivityComponent extends FbLoginFragment.Injector{

    void injectActivity(LoginActivity loginActivity);

}
