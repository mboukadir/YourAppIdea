package org.michenux.yourappidea;

import org.michenux.drodrolib.ApplicationScope;
import org.michenux.drodrolib.MCXComponent;
import org.michenux.yourappidea.tutorial.sync.SyncModule;
import org.michenux.yourappidea.tutorial.sync.TutorialSyncAdapter;
import org.michenux.yourappidea.tutorial.sync.TutorialSyncHelper;

import dagger.Component;

/**
 * @author Mohammed Boukadir  @:mohammed.boukadir@gmail.com
 *
 */

@ApplicationScope
@Component(
           dependencies = MCXComponent.class,
           modules = { YourAppModule.class,
                       SyncModule.class }
)
public interface YourAppComponent extends MCXComponent {

    void inject(YourApplication yourApplication);
    void inject(TutorialSyncAdapter tutorialSyncAdapter);

    TutorialSyncHelper getTutorialSyncHelper();
    NavigationController getNavigationController();

}
