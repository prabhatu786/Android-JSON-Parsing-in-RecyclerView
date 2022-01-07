package com.example.recyclerviewgridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    myadapter Adapter;
    private ArrayList<Modeldata> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcv.setLayoutManager(gridLayoutManager);
        // created new array list..
        arrayList = new ArrayList<>();

        getList();

    }

    private void getList() {
        String myJSONData = loadJSONFromAsset();
        try {
            //Get root JSON object node
            JSONObject jsonObject = new JSONObject(myJSONData);
            //Get data array node
            JSONArray jsonarray = jsonObject.getJSONArray("data");

            Adapter = new myadapter(jsonarray);
            rcv.setAdapter(Adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String loadJSONFromAsset (){
        String json;
        try {

            InputStream is = getAssets().open("Modeldata.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, StandardCharsets.UTF_8);


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;


    }


}

