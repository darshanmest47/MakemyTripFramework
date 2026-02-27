package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class PropertyReader {
    static PropertyReader propertyReader = null;

    /* Singleton Design pattern */
    private PropertyReader(){};

    public static PropertyReader getInstance(){
        if(propertyReader==null){
            propertyReader = new PropertyReader();
            return propertyReader;
        }else{
            return propertyReader;
        }
    }
    /* Singleton Design pattern */


    // Method to get value from .properties file
    public String getPropertyValue(String key){
        try {
            FileInputStream fis = new FileInputStream(".\\src\\test\\java\\Config.properties");
            Properties properties = new Properties();
            properties.load(fis);
//            return String.valueOf(properties.get(key));

           HashMap<String,Object> hmap = new HashMap<>();


            /*Storing the data from .properties into a hashmap*/
            for(Map.Entry<Object, Object> value:properties.entrySet()){
                hmap.put(String.valueOf(value.getKey()),value.getValue());
            }
            /*Storing the data from .properties into a hashmap*/

            return String.valueOf(hmap.get(key));
        } catch (Exception e) {
            System.out.println("Error in opening the file");
        }
        return null;
    }

}
