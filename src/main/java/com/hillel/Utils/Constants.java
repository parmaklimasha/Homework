package com.hillel.Utils;

public class Constants {
    public static String HEROKUAPP_URL = "";
    public static String DRAG_AND_DROP = "";
            static {
                HEROKUAPP_URL = System.getProperty("herokuapp.url", "http://the-internet.herokuapp.com");
                DRAG_AND_DROP = System.getProperty("draganddrop.url", "http://www.pureexample.com/jquery-ui/basic-droppable.html");
            }
}
