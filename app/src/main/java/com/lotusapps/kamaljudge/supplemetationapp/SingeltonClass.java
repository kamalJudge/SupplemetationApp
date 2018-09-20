package com.lotusapps.kamaljudge.supplemetationapp;

import java.util.ArrayList;

public class SingeltonClass
{
    private static SingeltonClass singleton = new SingeltonClass( );

    private SingeltonClass() { }
    public static SingeltonClass getInstance( ) {
        return singleton;
    }

    protected static void demoMethod( )
    {
        System.out.println("demoMethod for singleton");
    }

    String[] singeltonTitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 4","Title 4",
            "Title 4","Title 4",
    };

    String[] singeltonImgid={
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
    };

    String[] singeltonsubTitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
    };

    String[] singeltonsubImgid={
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
            "https://www.mcdonalds.com/content/dam/prelaunch/ca/web/promotions/desktop/en/McDELIVERY-PromoTile.jpg",
    };

    String descriptionId , descriptionName;
    ArrayList<String> cartName = new ArrayList<>();
    ArrayList<String> cartID = new ArrayList<>();

    ArrayList<String> ordersName = new ArrayList<>();
    ArrayList<String> ordersAddress = new ArrayList<>();
}
