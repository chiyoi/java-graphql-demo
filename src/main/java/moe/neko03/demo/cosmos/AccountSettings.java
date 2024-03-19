package moe.neko03.demo.cosmos;

public class AccountSettings {

    public static String KEY = System.getProperty("COSMOS_ACCOUNT_KEY", System.getenv().get("COSMOS_ACCOUNT_KEY"));

    public static String HOST = System.getProperty("COSMOS_ACCOUNT_HOST", System.getenv().get("COSMOS_ACCOUNT_HOST"));
}
