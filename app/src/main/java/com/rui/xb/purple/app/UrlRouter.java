package com.rui.xb.purple.app;


/**
 * Created by Rui on 2018/5/31.
 */

public class UrlRouter {

    /**
     * 标记、是否使用https
     */
    static boolean USE_SSL = false;

    static String SCHEME = USE_SSL ? "https://" : "http://";

//    static String HOSTS = "47.95.202.154:8080/purple/";
    static String HOSTS = "10.2.99.124:8080/";

    public static final String BASE_URL = SCHEME + HOSTS;

    public static final String LOGIN = BASE_URL + "api/user/login";

    public static final String LOGOUT = BASE_URL + "api/user/logout";

    public static final String CATEGORY = BASE_URL + "api/category/subClass";

    public static final String PRODUCT_LIST = BASE_URL + "api/product/list";

    public static final String PRODUCT_DETAIL = BASE_URL + "api/product/detail";

    public static final String CONFIRM_ORDER = BASE_URL + "api/trade/confirmOrder";

    public static final String SUBMIT_ORDER = BASE_URL + "api/trade/submitOrder";

    public static final String ADDRESS_LIST = BASE_URL + "api/user/receiveList";

    public static final String ADDRESS_ADD_DELETE = BASE_URL + "api/user/addDeleteReceive";

    public static final String ADDRESS_EDIT = BASE_URL + "api/user/editReceive";

    public static final String ORDER_LIST = BASE_URL + "api/trade/myBuyAndSell";

    public static final String COLLECT_LIST = BASE_URL + "api/product/collectList";

    public static final String MY_DISPATCH_REQUEST = BASE_URL + "api/product/IdlesOrRequests";


}
