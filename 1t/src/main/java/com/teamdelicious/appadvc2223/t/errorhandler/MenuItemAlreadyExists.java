package com.teamdelicious.appadvc2223.t.errorhandler;

public class MenuItemAlreadyExists extends RuntimeException{

    private String message;

    public MenuItemAlreadyExists() {}

    public MenuItemAlreadyExists(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
