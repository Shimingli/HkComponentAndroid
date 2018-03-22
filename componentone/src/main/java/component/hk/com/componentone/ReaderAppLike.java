package component.hk.com.componentone;

import component.hk.com.componentlib.IApplicationLike;
import component.hk.com.componentlib.Router;
import component.hk.com.componentlib.UIRouter;
import component.hk.com.hkcomponentservice.readerbook.BaseServiceFragment;

//ReaderAppLike相当于组件的application类，
// 这里定义了onCreate和onStop两个生命周期方法，对应组件的加载和卸载。
public class ReaderAppLike implements IApplicationLike {

    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        System.out.println("shiming ReaderAppLike");
        uiRouter.registerUI("reader");
        router.addService(BaseServiceFragment.class.getSimpleName(), new ReadBookServiceImplKotlin());
    }

    @Override
    public void onStop() {
        uiRouter.unregisterUI("reader");
        router.removeService(BaseServiceFragment.class.getSimpleName());
    }
}
