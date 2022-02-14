package com.project.UI;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class MainApp {
   private static Logger logger= LogManager.getLogger(MainApp.class);
    public static void main(String[] args) {
        new Welcome();
    }
}
