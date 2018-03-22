package component.hk.com.componentlib;


public interface ISyringe {
    /**
     * @param self the container itself, members to be inject into have been annotated
     *             with one annotation called Autowired
     */
    void inject(Object self);
}
