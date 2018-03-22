package component.hk.com.componentlib;


public interface AutowiredService {
    boolean THROW_CONFIG = true;

    /**
     * Autowired core.
     *
     * @param instance the instance who need autowired.
     */
    void autowire(Object instance);


    class Factory {
        private static Factory instance;

        public static Factory getInstance() {
            if (instance == null) {
                instance = new Factory();
            }
            return instance;
        }

        public AutowiredService create() {
            return new AutowiredServiceImpl();
        }
    }
}
