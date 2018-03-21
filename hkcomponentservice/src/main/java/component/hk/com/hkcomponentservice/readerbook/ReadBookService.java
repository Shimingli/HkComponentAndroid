package component.hk.com.hkcomponentservice.readerbook;
import android.app.Fragment;



/**
 * export module services
 * Created by mrzhang on 2017/6/15.
 */
//在demo中我们让reader提供一个fragment给app使用来说明。
// 首先reader组件在componentservice中定义自己的服务
public interface ReadBookService {

    Fragment getReadBookFragment();
}
