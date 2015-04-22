package org.michenux.drodrolib;

import android.app.Application;
import android.content.Context;

public abstract  class MCXApplication extends Application {

    public static final String LOG_TAG = "MCX";

    private MCXComponent component;


    @Override public void onCreate() {
        super.onCreate();
        initializeInjector();
        doAfterFwkInitializeInjector();
    }

    private void initializeInjector() {

        component = DaggerMCXComponent.builder().mCXModule(new MCXModule()).build();
        component.inject(this);
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
