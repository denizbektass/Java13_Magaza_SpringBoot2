package com.dennis.constants;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";

    private static final String ROOT = DEV + VERSION;

    public static final String AUTH = ROOT + "/auth";
    public static final String BRAND = ROOT + "/brand";
    public static final String USER = ROOT + "/user";
    public static final String MODEL = ROOT + "/model";
    public static final String PRODUCT = ROOT + "/product";
    public static final String PFEATURE = ROOT + "/pfeature";

    public static final String ADD = "/add";
    public static final String GET_ALL = "/get-all";
    public static final String GET_ALL_BY_SIZE = "/get-all-by-size";
    public static final String GET_BY_ID = "/get-by-id";
    public static final String DELETE_BY_ID = "/delete-by-id";
    public static final String REGISTER = "/register";
    public static final String SAVEUSERIMAGE = "/save-user-image";
    public static final String SAVEPRODUCT = "/save-product";



}
