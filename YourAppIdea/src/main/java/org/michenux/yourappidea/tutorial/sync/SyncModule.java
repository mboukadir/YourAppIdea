package org.michenux.yourappidea.tutorial.sync;

import org.michenux.drodrolib.ApplicationScope;

import dagger.Module;
import dagger.Provides;
/**
 * @author Mohammed Boukadir  @:mohammed.boukadir@gmail.com
 */
@Module
public class SyncModule {

    @Provides @ApplicationScope TutorialSyncHelper provideTutorialSyncHelper() {
        return new TutorialSyncHelper();
    }
}
