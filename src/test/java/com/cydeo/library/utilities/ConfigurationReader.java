package com.cydeo.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties = new Properties();// static so
    // it will run before anything else
    static {



        try {
            FileInputStream file = new FileInputStream("configuration.properties");

            properties.load(file);

            file.close();// better to close the file

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found int he configurationReader class");
        }

    }


    public static  String getProperty (String Keyword){
        return properties.getProperty(Keyword);//it will scan the properties file and
        // return value that matches keyword we entered
    }





}
