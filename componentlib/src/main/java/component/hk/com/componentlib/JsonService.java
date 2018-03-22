package component.hk.com.componentlib;


import java.util.List;

public interface JsonService {

    <T> T parseObject(String text, Class<T> clazz);

    <T> List<T> parseArray(String text, Class<T> clazz);

    String toJsonString(Object instance);

    class Factory {
        private static Factory instance;

        public static Factory getInstance() {
            if (instance == null) {
                instance = new Factory();
            }
            return instance;
        }

        public JsonService create() {
            return new JsonServiceImpl();
        }
    }


}
