package com.hk.component;
import component.hk.com.basicres.BaseApplication;
import component.hk.com.componentlib.Router;
import component.hk.com.componentlib.UIRouter;

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        UIRouter.getInstance().registerUI("app");

        //如果isRegisterCompoAuto为false，则需要通过反射加载组件
        Router.registerComponent("component.hk.com.componentone.ReaderAppLike");
//        Router.registerComponent("com.luojilab.share.applike.ShareApplike");
    }


}
