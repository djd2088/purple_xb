package com.rui.xb.purple.utils;


/**
 * Created by Rui on 2018/5/31.
 */

public class UrlRoute {

    /**
     * 标记、是否使用https
     */
    static boolean USE_SSL = false;

    static String SCHEME = USE_SSL ? "https://" : "http://";

    static String HOSTS = "47.95.202.154:8080/purple/";
//    static String HOSTS = "10.2.99.201:8080";

    public static final String BASE_URL = SCHEME + HOSTS;

    public static final String LOGIN = BASE_URL + "/api/user/login";

    public static final String LOGOUT = BASE_URL + "/api/user/logout";

    public static final String CATEGORY = BASE_URL + "api/category/subClass";

}
