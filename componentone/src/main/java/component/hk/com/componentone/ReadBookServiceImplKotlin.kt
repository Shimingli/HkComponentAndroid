package com.luojilab.reader.serviceimpl

import android.support.v4.app.Fragment
import component.hk.com.componentone.ReaderFragment
import component.hk.com.hkcomponentservice.readerbook.BaseServiceFragment


/**
 * Created by mrzhang on 2018/2/9.
 */
class ReadBookServiceImplKotlin : BaseServiceFragment {
    override fun getFragment(): Fragment {
        return ReaderFragment()
    }

}
