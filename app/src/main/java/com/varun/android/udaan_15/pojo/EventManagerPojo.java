package com.varun.android.udaan_15.pojo;

/**
 * Created by Varun Barad on 2015-03-20.
 */
public class EventManagerPojo {

    private String name;
    private String email;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if((number.length() == 13) && (number.startsWith("+91"))) {
            this.number = number;
        } else if(number.length() == 10) {
            this.number = "+91" + number;
        }
    }
}
