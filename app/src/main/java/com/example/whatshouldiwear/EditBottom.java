package com.example.whatshouldiwear;
/** Code Behind for editing items you wear on your bottom and feet
 *
 * @author Peter Saunders
 * @version 1.0
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditBottom extends FragmentActivity {
    private RecyclerView recyclerView;
    private ArrayList<Item> outfitItems;

    private View mainBar;
    private WhatShouldIWearDB db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_edit_bottom);

        /**
         * Finds the recycler view and fills it with items labelled
         * 2 for bottoms
         */
        recyclerView = findViewById(R.id.recycler_edithead);
        db = new WhatShouldIWearDB(this);
        outfitItems = db.getItemsForPosition(2);
        ItemAdapter itemAdapter = new ItemAdapter(this, outfitItems);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(itemAdapter);

        /**
         * listener for the top app bar so you you can go backwards
         */
        mainBar = findViewById(R.id.topAppBar);
        mainBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}