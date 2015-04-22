package org.michenux.yourappidea;

import org.michenux.drodrolib.ApplicationScope;

import dagger.Module;
import dagger.Provides;


@Module
public class YourAppModule {


    private YourApplication app;

    public YourAppModule(YourApplication app) {
        this.app = app;
    }
    @Provides @ApplicationScope
    public YourApplication provideApplication() {
        return  app;
    }

    @Provides @ApplicationScope
    public NavigationController provideNavigationController() {
        return new NavigationController();
    }

}
