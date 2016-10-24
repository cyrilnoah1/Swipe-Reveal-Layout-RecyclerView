package com.cyril.training.dayseventeen;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    RecyclerAdapter mRecyclerAdapter;
    RecyclerView.LayoutManager mRecyclerLayoutManager;
    RecyclerView mRecyclerView;
    List<RecyclerData> mRecyclerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecyclerData = new ArrayList<>();
        mRecyclerAdapter = new RecyclerAdapter(mRecyclerData, this);

        mRecyclerLayoutManager = new LinearLayoutManager(getApplicationContext());

        mRecyclerView = (RecyclerView) findViewById(R.id.game_recycler_view);
        mRecyclerView.setLayoutManager(mRecyclerLayoutManager);

        // Setting an item animator for every item that is populated in the list.
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mRecyclerAdapter);

        recyclerListWithTimelineData();
    }

    /**
     * Method to populate data containing TimeLineView drawable and Text into the RecyclerView
     */
    public void recyclerListWithTimelineData() {
        try {
            RecyclerData recyclerData = new RecyclerData(
                    "Timeline data 1 loaded.");
            mRecyclerData.add(recyclerData);

            RecyclerData recyclerData2 = new RecyclerData(
                    "Timeline data 2 loaded.");
            mRecyclerData.add(recyclerData2);

            RecyclerData recyclerData3 = new RecyclerData(
                    "Timeline data 3 loaded.");
            mRecyclerData.add(recyclerData3);

            RecyclerData recyclerData4 = new RecyclerData(
                    "Timeline data 4 loaded.");
            mRecyclerData.add(recyclerData4);

            RecyclerData recyclerData5 = new RecyclerData(
                    "Timeline data 5 loaded.");
            mRecyclerData.add(recyclerData5);

            RecyclerData recyclerData6 = new RecyclerData(
                    "Timeline data 6 loaded.");
            mRecyclerData.add(recyclerData6);

            RecyclerData recyclerData7 = new RecyclerData(
                    "Timeline data 7 loaded.");
            mRecyclerData.add(recyclerData7);

            RecyclerData recyclerData8 = new RecyclerData(
                    "Timeline data 8 loaded.");
            mRecyclerData.add(recyclerData8);

            mRecyclerAdapter.notifyDataSetChanged();
        } catch (NullPointerException nPE) {
            nPE.printStackTrace();
        } catch (Resources.NotFoundException nFE) {
            nFE.printStackTrace();
        }
    }

    /**
     * Method to go to Activity-3, on button click.
     *
     * @param v
     */
    public void gotoActivity3Button(View v) {
      /*  Intent intent= new Intent(this, Main3Activity.class);
        startActivity(intent);*/
    }
}
