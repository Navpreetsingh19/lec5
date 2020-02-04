package com.example.lec5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> attrList =new ArrayList<>();

    List<Integer> attrPics= new ArrayList<>();

    private void addItems()
    {
        attrList.add("Magnificent mile");
        attrList.add("Navy pier");
        attrList.add("Art Institute of Chicago");
        attrPics.add(R.drawable.magmile);
        attrPics.add(R.drawable.pier);
        attrPics.add(R.drawable.artinst);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItems();

        ListView ListViewItems=findViewById(R.id.ListViewItems);

         ListViewItems.setAdapter(new ArrayAdapter<>(this,
                 android.R.layout.simple_list_item_1,attrList));

         MyCustomAdapter myAdapter =new MyCustomAdapter(this,attrList,attrPics);

         ListViewItems.setAdapter(myAdapter);

    }
}
