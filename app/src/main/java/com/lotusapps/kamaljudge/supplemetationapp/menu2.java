package com.lotusapps.kamaljudge.supplemetationapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;


public class menu2 extends Fragment {
    @Nullable
    String[] itemname ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };

    ListView list;
    SingeltonClass singeltonObj;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        singeltonObj = singeltonObj.getInstance( );
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View rootView = inflater.inflate(R.layout.fragment_menu_2, container, false);
        MyListAdaptor adapter = new MyListAdaptor(getActivity(), singeltonObj.singeltonTitle, singeltonObj.singeltonTitle,singeltonObj.singeltonImgid);
        list=(ListView)rootView.findViewById(R.id.list2);
        list.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_menu_2, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("CART");
    }
}
