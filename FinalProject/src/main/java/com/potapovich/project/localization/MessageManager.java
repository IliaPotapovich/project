package com.potapovich.project.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {


    private String sessionLocale;
    private ResourceBundle bundle;

   public MessageManager(String sessionLocale) {

        this.sessionLocale = sessionLocale;
    }

    public void setResourceBundle(String sessionLocale){
       if (sessionLocale!=null) {
           if (sessionLocale.equals("be_BY")) {
               bundle = ResourceBundle.getBundle("messages", new Locale("be", "BY"));
           }
           if (sessionLocale.equals("en_US")) {
               bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
           }
           if (sessionLocale.equals("ru_RU")) {
               bundle = ResourceBundle.getBundle("messages", new Locale("ru", "RU"));
           }
       }
       else {
           bundle = ResourceBundle.getBundle("messages", new Locale("ru", "RU"));
       }
    }

    public String getMessage(String key){

       setResourceBundle(sessionLocale);
        return bundle.getString(key);
    }


















      /*   if (sessionLocale!=null) {
         switch (sessionLocale) {
             case "be_BY": {
                 bundle = ResourceBundle.getBundle("messages", new Locale("be", "BY"));
                 break;
             }

             case "en_US": {
                 bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
                 break;
             }
             case "ru_RU": {
                 bundle = ResourceBundle.getBundle("messages", new Locale("ru", "RU"));
                 break;
             }
             default: {
                 bundle = ResourceBundle.getBundle("messages", new Locale("ru", "RU"));
                 break;
             }
         }
     }
     else {
         bundle = ResourceBundle.getBundle("messages", new Locale("ru", "RU"));

     }
     */


}
