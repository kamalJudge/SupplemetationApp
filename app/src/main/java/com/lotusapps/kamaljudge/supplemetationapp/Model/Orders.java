package com.lotusapps.kamaljudge.supplemetationapp.Model;

public class Orders {
    private String Name;
    private String Password;
    private String Phone;

    public Orders()
    {

    }

    public Orders(String name, String password)
    {
        Name = name;
        Password = password;
    }

    public void setName(String name)
    {
        Name = name;
    }
    public String getName(){
        return Name;
    }
    public  void setPassword(String password)
    {
        Password = password;
    }
    public String getPassword() {
        return Password;
    }
    public void setPhone(String phone)
    {
        Phone = phone;
    }
    public String getPhone()
    {
        return  Phone;
    }
}