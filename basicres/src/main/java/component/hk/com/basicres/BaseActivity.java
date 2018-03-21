package component.hk.com.basicres;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import component.hk.com.basiclib.ToastManager;
import component.hk.com.componentlib.AutowiredService;


/**
 * Created by mrzhang on 2018/1/16.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutowiredService.Factory.getInstance().create().autowire(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ToastManager.show(this,"按个Activity可见了啊"+this.getClass().getSimpleName());
    }
}
