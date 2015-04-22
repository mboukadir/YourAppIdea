package org.michenux.drodrolib;

import android.app.Application;
import android.content.Context;

public abstract  class MCXApplication extends Application {

    public static final String LOG_TAG = "MCX";

    /***
     * Injector
     */
    private MCXComponent component;


    @Override public void onCreate() {
        super.onCreate();
        initializeInjectorIfNeeded();
        doAfterFwkInitializeInjector();
    }


    /**
     * Usually the Application {@link #onCreate} method is the first method called by OS except
     * when the Application us same ContentProvider as In our case then OS call the ContentProvider
     * onCreate method first.
     * in this case :
     * This Method allows the initialization of injector from ContentProvider {@link org.michenux.drodrolib.db.AbstractContentProvider#onCreate()}.
     *
     */
    public void initializeInjectorIfNeeded() {

        if( component == null){
            component = DaggerMCXComponent.builder().mCXModule(new MCXModule()).build();
            component.inject(this);
        }

    }


    public MCXComponent mCXComponent() {
        return component;
    }

    public static MCXApplication get(Context context) {
        return (MCXApplication) context.getApplicationContext();
    }

    /**
     *
     */
    //TODO Rename this method
    abstract public void doAfterFwkInitializeInjector();

}
