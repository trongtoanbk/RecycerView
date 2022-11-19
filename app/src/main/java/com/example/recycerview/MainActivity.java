package com.example.recycerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvStore;
    StoreAdapter storeAdapter;
    List<Store> storeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvStore =findViewById(R.id.recycler_view_store);
        storeList = Store.getMock();
        storeAdapter = new StoreAdapter(storeList);
        rcvStore.setAdapter(storeAdapter);
    }
}