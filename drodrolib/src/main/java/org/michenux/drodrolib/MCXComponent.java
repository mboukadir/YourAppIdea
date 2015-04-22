package org.michenux.drodrolib;

import org.michenux.drodrolib.db.AbstractContentProvider;
import org.michenux.drodrolib.db.sqlite.SQLiteDatabaseFactory;
import org.michenux.drodrolib.gms.gplus.GooglePlusLoginFragment;
import org.michenux.drodrolib.network.volley.BitmapCacheHolder;
import org.michenux.drodrolib.security.UserHelper;
import org.michenux.drodrolib.ui.navdrawer.NavigationDrawerFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author mohammedboukadir
 */
@Singleton
@Component(modules= {MCXModule.class})
public interface MCXComponent {


    void inject(MCXApplication app);
    void inject(AbstractContentProvider contentProvider);
    void inject(GooglePlusLoginFragment googlePlusLoginFragment);
    void inject(NavigationDrawerFragment navigationDrawerFragment);

    SQLiteDatabaseFactory getSQLiteDatabaseFactory();
    BitmapCacheHolder getBitmapCacheHolder();
    UserHelper getUserHelper();

}
