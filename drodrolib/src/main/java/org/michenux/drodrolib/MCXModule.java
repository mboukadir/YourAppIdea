package org.michenux.drodrolib;

import org.michenux.drodrolib.db.sqlite.SQLiteDatabaseFactory;
import org.michenux.drodrolib.network.volley.BitmapCacheHolder;
import org.michenux.drodrolib.security.UserHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/*
@Module(injects = {
        SQLiteDatabaseFactory.class,
        BitmapCacheHolder.class,
        UserHelper.class,

        GooglePlusLoginFragment.class
    })
*/
@Module
public class MCXModule {




    @Provides @Singleton public SQLiteDatabaseFactory provideSQLiteDatabaseFactory(){
        return new SQLiteDatabaseFactory();
    }

    @Provides @Singleton public BitmapCacheHolder provideBitmapCacheHolder() {
        return new BitmapCacheHolder();
    }

    @Provides @Singleton public UserHelper provideUserHelper(){
        return new UserHelper();
    }



}
