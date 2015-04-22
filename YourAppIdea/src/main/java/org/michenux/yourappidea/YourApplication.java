package org.michenux.yourappidea;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import org.michenux.drodrolib.MCXApplication;
import org.michenux.drodrolib.db.sqlite.SQLiteDatabaseFactory;
import org.michenux.drodrolib.network.volley.BitmapCacheHolder;
import org.michenux.yourappidea.tutorial.sync.TutorialSyncHelper;

import android.content.Context;
import android.content.pm.PackageManager;

import javax.inject.Inject;

public class YourApplication extends MCXApplication {

    public static final String LOG_TAG = "YAI";

    private boolean syncAdapterRunning = false;

    private YourAppComponent mYourAppComponent;

    @Inject
    TutorialSyncHelper tutorialSyncHelper;

    @Inject
    SQLiteDatabaseFactory sQLiteDatabaseFactory;

    @Inject
    BitmapCacheHolder bitmapCacheHolder;



    @Override
    public void onCreate() {
        super.onCreate();

     //   this.injectSelf();

        // Enable tutorial sync
        this.tutorialSyncHelper.createTutorialAccount(this);

        // Initialize Universal Image Loader
        // Create global configuration and initialize ImageLoader with this configuration
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                //.showImageOnLoading(R.drawable.ic_stub) // resource or drawable
                //.showImageForEmptyUri(R.drawable.ic_empty) // resource or drawable
                //.showImageOnFail(R.drawable.ic_error) // resource or drawable
                //.resetViewBeforeLoading(false)  // default
                //.delayBeforeLoading(1000)
                .cacheInMemory(true) // default
                .cacheOnDisc(true) // default
                //.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                //.bitmapConfig(Bitmap.Config.ARGB_8888) // default
                //.decodingOptions(...)
                .displayer(new FadeInBitmapDisplayer(5000)) // default SimpleBitmapDisplayer,RoundedBitmapDisplayer(10),FadeInBitmapDisplayer
                //.handler(new Handler()) // default
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                //.memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                //.discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null)
                //.taskExecutor(...)
                //.taskExecutorForCachedImages(...)
                //.threadPoolSize(3) // default
                //.threadPriority(Thread.NORM_PRIORITY - 1) // default
                //.tasksProcessingOrder(QueueProcessingType.FIFO) // default
                //.denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                //.memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                //.discCache(new UnlimitedDiscCache(cacheDir)) // default
                //.discCacheSize(50 * 1024 * 1024)
                //.discCacheFileCount(100)
                //.discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                //.imageDownloader(new BaseImageDownloader(context)) // default
                //.imageDecoder(new BaseImageDecoder()) // default
                .defaultDisplayImageOptions(options) // default
                //.writeDebugLogs()
                .build();

        ImageLoader.getInstance().init(config);
    }

    public boolean isSyncAdapterRunning() {
        return syncAdapterRunning;
    }

    public void setSyncAdapterRunning(boolean syncAdapterRunning) {
        this.syncAdapterRunning = syncAdapterRunning;
    }


    @Override
    public void doAfterFwkInitializeInjector() {
        this.initialiseInjector();
        initSqliteDBFactory();
        initBitmapCacheHolder();

    }

    private void initialiseInjector() {

        mYourAppComponent = DaggerYourAppComponent.builder().mCXComponent(this.mCXComponent()).yourAppModule(new YourAppModule(this)).build();
        mYourAppComponent.inject(this);
    }

    private void initSqliteDBFactory() {

        try {
            sQLiteDatabaseFactory.init(this,true,true);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void initBitmapCacheHolder() {

        bitmapCacheHolder.init(this, 50000000);

    }

    public YourAppComponent yourAppComponent() {
        return mYourAppComponent;
    }

    public static YourApplication getYourApplication(Context context) {
        return (YourApplication) context.getApplicationContext();
    }




}
