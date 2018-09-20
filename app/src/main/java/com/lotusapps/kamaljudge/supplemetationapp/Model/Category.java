package com.lotusapps.kamaljudge.supplemetationapp.Model;

import java.util.List;

public class Category {
    private String Name;
    private String Image;


    public Category()
    {

    }

    public Category(String name, String image)
    {
        Name = name;
        Image = image;
    }

    public String getImage() {
        return Image;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

}
