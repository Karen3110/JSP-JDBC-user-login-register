package com.example.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsReader {
    public static Properties  loadProperties(String fileName) {
        Properties props=null;
        InputStream fis = null;
        try {
            fis = SQLConnector.class.getClassLoader().getResourceAsStream(fileName);
            props = new Properties();
            props.load(fis);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return props;
    }
}
