package com.heyx.tool.color.common.constant;

public interface SystemConst {


    String USER = "user";

    String ROLE = "role";

    String ROOT = "0";

    /**
     * pc菜单
     */
    Integer PC_MENU = 1;
    /**
     * 小程序菜单
     */
    Integer WX_MENU = 2;
    /**
     * 菜单权限
     */
    Integer PERM_MENU = 3;


    String PROFILE_DEV = "dev";

    String PROFILE_PROD = "prod";

    String PROFILE_TEST = "test";

    String RUN_MODE = "RUN_MODE";

    String VERSION = "/v1";

    String PREFIX =  "/api/";
    String PROJECT ="/color";
    String PC_MODE ="/pc";
    String WX_MODE ="/wx";

    String PC = PREFIX + PROJECT + VERSION + PC_MODE;
    String WX = PREFIX + PROJECT + VERSION + WX_MODE;

    String PC_TAG = "PC-";
    String WX_TAG = "WX-";

    /**
     * 公钥
     */
    String PUBLIC_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANCzAbDSLV/W56vC9ZvLvGGlRy0cs/55" +
            "qCB4ShFXOcYqSBcJ0PwvdmJ4sNzD5N+ymTYgyc+HNIVbFiCwTBwcarcCAwEAAQ==";
    /**
     * 私钥
     */
   String PRIVATE_KEY = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEA0LMBsNItX9bnq8L1" +
            "m8u8YaVHLRyz/nmoIHhKEVc5xipIFwnQ/C92Yniw3MPk37KZNiDJz4c0hVsWILBM" +
            "HBxqtwIDAQABAkBfm1HP9kkRGbtiBVtM9wWi2fuEYBzZHFR4I4MS9Jmj/NDSIvJ9" +
            "c9ICq9HP6Xe3iOVGnmipNhOl6ifQc3tzPnA5AiEA7c/7ZLjz10HpaXf0wczrreVf" +
            "DaheUOLz2FVu+LQQC5sCIQDgqQf9BMV+9b1T9u4x29nINvujV930+C0OjOM98mNV" +
            "FQIhAMS6hCXrltRg0z2LnW9hHSprEDoVKYjSZpR1AGs/UfK3AiB8pEsSTXtlHOGV" +
            "nAI7F0aUliy2SyGRr78Pu4q366rAoQIgdTpgag736kHdNwn2vLFx4g5C5qzfgFrw" +
            "6A4zMJ4ZysI=";

}