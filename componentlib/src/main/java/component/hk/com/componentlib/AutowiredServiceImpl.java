package component.hk.com.componentlib;

import android.util.Log;
import android.util.LruCache;

import java.util.ArrayList;
import java.util.List;



public class AutowiredServiceImpl implements AutowiredService {

    private LruCache<String, ISyringe> classCache = new LruCache<>(50);
    private List<String> blackList = new ArrayList<>();

    //attention! make sure this keeps same with the one in AutowiredProcessor
    private static final String SUFFIX_AUTOWIRED = "$$Router$$Autowired";

    @Override
    public void autowire(Object instance) {
        String className = instance.getClass().getName();
        try {
            if (!blackList.contains(className)) {
                ISyringe autowiredHelper = classCache.get(className);
                if (null == autowiredHelper) {  // No cache.
                    autowiredHelper = (ISyringe) Class.forName(instance.getClass().getName() + SUFFIX_AUTOWIRED)
                            .getConstructor().newInstance();
                }
                autowiredHelper.inject(instance);
                classCache.put(className, autowiredHelper);
            } else {
                // TODO: 2017/12/21 change to specific log system
                Log.d("[DDComponent]", "[autowire] " + className + "is in blacklist, ignore data inject");
            }
        } catch (Exception ex) {
            if (ex instanceof NullPointerException) { // may define custom exception better
                throw new NullPointerException(ex.getMessage());
            }
            ex.printStackTrace();
            blackList.add(className);    // This instance need not autowired.
        }
    }
}
