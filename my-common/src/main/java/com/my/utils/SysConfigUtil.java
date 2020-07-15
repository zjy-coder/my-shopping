package com.my.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SysConfigUtil {
    private static Properties properties = new Properties();

    private SysConfigUtil(){};

    public static SysConfigUtil getSysConfigUtil(String s) {

        InputStream inputStream = SysConfigUtil.class.getClassLoader().getResourceAsStream(s);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SysConfigUtil();
    }

    public static String getString(String key){
        return properties.getProperty(key);
    }

    public static int getInt(String key){
        return Integer.valueOf(properties.getProperty(key));
    }

    public static boolean getBoolean(String key){
        return Boolean.valueOf(properties.getProperty(key));
    }

    public static void main(String[] args) {

//        String jarPath = SysConfigUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//        System.out.println(jarPath);
//        String configPath = jarPath+"redis.properties";
//        System.out.println(configPath);

//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(new File(configPath));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Properties properties = new Properties();
//
//        try {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(properties.get("spring.redis.host"));
    }
}