package com.huskehhh.code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    
    public static String hostname;
    public static String port;
    public static String user;
    public static String password;
    public static String database;
    
    public static String Ohostname;
    public static String Oport;
    public static String Ouser;
    public static String Opassword;
    public static String Odatabase;
    public static String[] channels;
    public static String network;
    public static String nickPass;
    public static String ircuser;
    
    public static void loadConfiguration() throws FileNotFoundException, IOException {
        
        Properties config = new Properties();
        config.load(new FileInputStream("HuskyIRC.properties"));
        
        hostname = config.getProperty("MySQL-host");
        port = config.getProperty("MySQL-port");
        user = config.getProperty("MySQL-user");
        password = config.getProperty("MySQL-password");
        database = config.getProperty("MySQL-database");
        
        network = config.getProperty("irc-network");
        nickPass = config.getProperty("nickserv-pass");
        channels = config.getProperty("channels").split(",");
        ircuser = config.getProperty("ircuser");
        
        Ohostname = config.getProperty("OMySQL-host");
        Oport = config.getProperty("OMySQL-port");
        Ouser = config.getProperty("OMySQL-user");
        Opassword = config.getProperty("OMySQL-password");
        Odatabase = config.getProperty("OMySQL-database");
        
        
    }

}
