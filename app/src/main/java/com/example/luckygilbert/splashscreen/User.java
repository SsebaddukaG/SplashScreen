package com.example.luckygilbert.splashscreen;

/**
 * Created by LuckyGilbert on 03-Jan-18.
 */

public class User {
    private String name;
    private String password;
    private int id;

    public User()
    {

        name = "Lucky Gilbert";
        password = "GodAbove";


    }

    public User(String Name, String Password, int ID)
    {
        this.name = Name;
        this.password = Password;
        this.id = ID;
    }

    public void setName(String Name)
    {
        this.name = Name;
    }

    public String getName()
    {
        return name;
    }

    public void setPassword(String Password)
    {
        this.password = Password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setId(int ID)
    {
        this.id = ID;
    }

    public int getId()
    {
        return id;
    }
}
