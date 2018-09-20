package com.lotusapps.kamaljudge.supplemetationapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class menu1 extends Fragment {


    ListView list;
    SingeltonClass singeltonObj;


    String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        singeltonObj = singeltonObj.getInstance( );

        View rootView = inflater.inflate(R.layout.fragment_menu_1, container, false);
        MyListAdaptor adapter = new MyListAdaptor(getActivity(), singeltonObj.singeltonTitle, subtitle,singeltonObj.singeltonImgid);
        list=(ListView)rootView.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Intent productIntent = new Intent(getContext(),ProductsActivity.class);
                startActivity(productIntent);
               
            }
        });
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Home");

    }

}
