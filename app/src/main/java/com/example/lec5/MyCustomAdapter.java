package com.example.lec5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyCustomAdapter extends BaseAdapter {

    List<String> adapterList;
    List<Integer> adapterPics;
    Context context;
    public MyCustomAdapter(Context context,List<String> myList,
                           List<Integer> myPics ){
        adapterList=myList;
        adapterPics =myPics;
        this.context =context;



    }

    @Override
    public int getCount() {
        //must reflect size of your data
        return adapterList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView==null){
           LayoutInflater myLayoutInflater= LayoutInflater.from(parent.getContext());
           //parameter,root,attackRoot
           convertView=myLayoutInflater.inflate(R.layout.layout_item,parent,false);
       }
        TextView txtViewItem=convertView.findViewById(R.id.textViewItem);
       txtViewItem.setText(adapterList.get(position ));
        Drawable img=parent.getResources().getDrawable(adapterPics.get(position));
        //set drawable bounce 4parameter (0,0)()
        img.setBounds(0,0,80,80);
        // setCompoundDrawables set the drawable where we have to place image, text.
        txtViewItem.setCompoundDrawables(img,null,null,null);
        txtViewItem.setCompoundDrawablePadding(16);
        return convertView;
    }
}
