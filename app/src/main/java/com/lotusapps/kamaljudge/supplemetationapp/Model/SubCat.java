package com.lotusapps.kamaljudge.supplemetationapp.Model;

public class SubCat {
    private String Name;
    private String Image;


    public SubCat()
    {

    }

    public SubCat(String name, String image)
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
