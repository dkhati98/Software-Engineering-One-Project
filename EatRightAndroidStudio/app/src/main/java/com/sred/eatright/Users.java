package com.sred.eatright;

public class Users {
    private String _username;
    private String _password;

    public Users(){

    }

    public Users(String username) {
        this._username = username;
    }
    public Users(String password) {
        this._password = password;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_username() {
        return _username;
    }

    public String get_password() {
        return _password;
    }
}
