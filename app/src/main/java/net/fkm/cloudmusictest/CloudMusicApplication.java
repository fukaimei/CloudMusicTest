package net.fkm.cloudmusictest;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;


public class CloudMusicApplication extends Application {

    private static CloudMusicApplication cloudMusicApplication;

    public static CloudMusicApplication getInstance() {
        return cloudMusicApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        cloudMusicApplication = this;
        initTextSize();
    }

    /**
     * 使其系统更改字体大小无效
     */
    private void initTextSize() {
        Resources res = getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

}
