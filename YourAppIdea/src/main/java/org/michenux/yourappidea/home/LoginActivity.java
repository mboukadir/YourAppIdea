package org.michenux.yourappidea.home;

import org.michenux.yourappidea.HasComponent;
import org.michenux.yourappidea.R;
import org.michenux.yourappidea.YourAppComponent;
import org.michenux.yourappidea.YourApplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class LoginActivity extends ActionBarActivity implements HasComponent<LoginActivityComponent> {


    private LoginActivityComponent component;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector(YourApplication.getYourApplication(this).yourAppComponent());
        setContentView(R.layout.login);

        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = (Fragment) getSupportFragmentManager().findFragmentByTag("googlePlusFragment");
        if(fragment != null){
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public LoginActivityComponent getComponent() {
        return component;
    }

    private void initializeInjector(YourAppComponent yourAppComponent) {

        component = DaggerLoginActivityComponent.builder().yourAppComponent(
                yourAppComponent).loginActivityModule(new LoginActivityModule(this)).build();
        component.injectActivity(this);

    }

}
