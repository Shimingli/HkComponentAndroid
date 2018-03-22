package com.hk.component;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import component.hk.com.basicres.BaseActivity;
import component.hk.com.componentlib.Router;
import component.hk.com.componentlib.router.annotation.RouteNode;
import component.hk.com.hkcomponentservice.readerbook.BaseServiceFragment;

@RouteNode(path = "/main", desc = "首页")
public class MainActivity extends BaseActivity implements View.OnClickListener {
    Fragment fragment;
    FragmentTransaction ft;

    Button installReadBookBtn;
    Button uninstallReadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        installReadBookBtn = findViewById(R.id.install_share);
        uninstallReadBtn = findViewById(R.id.uninstall_share);
        installReadBookBtn.setOnClickListener(this);
        uninstallReadBtn.setOnClickListener(this);
        showFragment();
    }

    private void showFragment() {
        if (fragment != null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.remove(fragment).commit();
            fragment = null;
        }
        /**
         * 在app中如何使用如reader组件提供的ReaderFragment呢？注意此处app是看不到组件的任何实现类的，
         * 它只能看到componentservice中定义的ReadBookService，所以只能面向ReadBookService来编程。具体的实例代码如下：
         */
        Router router = Router.getInstance();
        System.out.println("shiming BaseServiceFragment.class.getSimpleName()=="+BaseServiceFragment.class.getSimpleName());
        if (router.getService(BaseServiceFragment.class.getSimpleName()) != null) {
            BaseServiceFragment service = (BaseServiceFragment) router.getService(BaseServiceFragment.class.getSimpleName());
            fragment = service.getFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.install_share:
                Router.registerComponent("com.luojilab.share.applike.ShareApplike");
                Router.registerComponent("com.luojilab.share.kotlin.applike.KotlinApplike");
                break;
            case R.id.uninstall_share:
                Router.unregisterComponent("com.luojilab.share.applike.ShareApplike");
                Router.unregisterComponent("com.luojilab.share.kotlin.applike.KotlinApplike");
                break;
        }
    }
}
