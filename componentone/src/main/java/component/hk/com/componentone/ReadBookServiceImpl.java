package component.hk.com.componentone;

import android.support.v4.app.Fragment;


import component.hk.com.hkcomponentservice.readerbook.BaseServiceFragment;


//然后在自己的组件工程中，提供具体的实现类ReadBookServiceImpl：
public class ReadBookServiceImpl implements BaseServiceFragment {
    @Override
    public Fragment getFragment() {
        return new ReaderFragment();
    }
}
