package com.exchanehome.isep.exception;

public class SiteNotFoundException extends RuntimeException{
    public SiteNotFoundException(Long siteid){
        super("The site id '" + siteid + "' does not exist in our records");
    }
}
