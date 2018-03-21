package component.hk.com.basicres;

import android.app.Application;
import android.support.annotation.Nullable;

import component.hk.com.basiclib.ToastManager;

/**
 * Created by mrzhang on 2018/1/16.
 */

public class BaseApplication extends Application {

    private static BaseApplication mAppCotext;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("shiming BaseApplication");
        ToastManager.show(this,this.getClass().getSimpleName());
        mAppCotext = this;
    }

    @Nullable
    public static Application getAppContext() {
        return mAppCotext;
    }
}
