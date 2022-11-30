package com.teamdelicious.appadvc2223.t.errorhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MenuItemNotFoundException extends Throwable {

    /*
    @ExceptionHandler
    public MenuItemNotFoundException(String message) {
        super(message);
    }
     */

}
