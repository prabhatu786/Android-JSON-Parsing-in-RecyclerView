

# Android JSON Parsing in RecyclerView


Hi Android developer!

JSON (JavaScript Object Notation) is readable format for structuring data. It is used to transmit data between a server and web application. If you want to get data from a JSON file. First you have to parse JSON data then you can use that data to display. In this example you will learn how to parse JSON data from assets folder.

# Android JSON Parsing without Any Library
 ![JSON-Data-Structure](https://user-images.githubusercontent.com/59795901/147826746-9ad57259-2fc1-401f-aa99-e358e2b48221.png)

 


## Step 1: Create New Project
Create a new project in Android Studio from File ⇒ New Project and select Empty Activity from the templates.

## Step 2: Create Assets Folder
Create a assets folder inside main directory and put your JSON file inside it.

![assets-folder-in-the-android-studio](https://user-images.githubusercontent.com/59795901/147826999-7f043e26-e894-4f19-a0d8-ab5036a281ec.png)



 Project ⇒ app ⇒ src ⇒ main ⇒ assets⇒ Modeldata.json

         {
        "data":[

                    {
                    "courses": "java",
                    "Url":"https://cavanzyl.files.wordpress.com/2016/04/programming.jpg?w=444",
                    "mentor":" by adarsh sir",
                    "price": "120"
                    },

                    {
                    "courses": "python",
                    "Url":"https://cavanzyl.files.wordpress.com/2016/04/programming.jpg?w=444",
                    "mentor":" by rakesh sir",
                    "price": "120"
                    }
                ]
        } 

 ## Step 3: Load JSON Data From Assets Folder
To load JSON data from assets folder, open the Activity and add the code below.



public String loadJSONFromAsset(String fileName)

    {
        String json;
        try
        {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

# Step 4: Display JSON Data in the RecyclerView


4.1: Add RecyclerView dependencies to the App Level Gradle.

Project ⇒ app ⇒ build.gradle



    build.gradle

    dependencies    
    {
    
    implementation 'androidx.recyclerview:recyclerview:1.1.0'

    }

## 4.2: Add the RecyclerView to the Activity Layout.

    <?xml version="1.0" encoding="utf-8"?>
        <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            tools:context=".MainActivity">
            <androidx.recyclerview.widget.RecyclerView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:id="@+id/recyclerview"/>
    </androidx.constraintlayout.widget.ConstraintLayout>

 ##   4.3: Create a model class that represents  Data details.
    package com.example.recyclerviewgridlayout;

    public class Modeldata {
        private String courses, Url, mentor,price;

        public String getCourses() {
            return courses;
        }

        public void setCourses(String courses) {
            this.courses = courses;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }

        public String getMentor() {
            return mentor;
        }

        public void setMentor(String mentor) {
            this.mentor = mentor;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
        public Modeldata(){

        }

        public Modeldata(String courses, String url, String mentor, String price) {
            this.courses = courses;
            this.Url = url;
            this.mentor = mentor;
            this.price = price;
        }
    }

   ## 4.4: Create a layout resource file. This layout will used to display Data details in the RecyclerView.
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#3F51B5">

        <androidx.cardview.widget.CardView
            android:layout_width="150dp"
            android:layout_height="200dp"
            android:layout_gravity="center"
            android:layout_marginStart="5dp"
            android:layout_marginTop="15dp"
            android:layout_marginEnd="5dp"
            android:layout_marginBottom="5dp"
            app:cardCornerRadius="10dp"
            app:cardElevation="5dp">

            <LinearLayout
                android:layout_width="150dp"
                android:layout_height="wrap_content"
                android:orientation="vertical">

                <ImageView
                    android:id="@+id/img1"
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    android:layout_gravity="center"
                    android:src="@mipmap/ic_launcher" />

                <TextView
                    android:id="@+id/text1"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"

                    android:paddingEnd="20dp"
                    android:text="@string/Courses"
                    android:textAlignment="center"
                    android:textStyle="bold" />

                <TextView
                    android:id="@+id/text2"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="20dp"
                    android:paddingEnd="20dp"
                    android:paddingBottom="10dp"
                    android:text="@string/teachers"
                    android:textAlignment="center"
                    android:textSize="12dp" />

                <View
                    android:layout_width="match_parent"
                    android:layout_height="1dp"
                    android:background="#9C9494" />

                <TextView
                    android:id="@+id/text3"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="10dp"
                    android:paddingStart="90dp"
                    android:text="@string/price"
                    android:textAlignment="center" />


            </LinearLayout>

        </androidx.cardview.widget.CardView>

    </RelativeLayout>
   ## Output of Layout Resource File.
![layout](https://user-images.githubusercontent.com/59795901/147827006-4325cebf-a941-432e-8e4c-c4d95c915c1a.png)

  ##   4.5: Create a Adapter for the myadapter.
    package com.example.recyclerviewgridlayout;

    import android.content.Context;
    import android.content.Intent;
    import android.graphics.ColorSpace;
    import android.icu.text.Transliterator;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import com.squareup.picasso.Picasso;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.ArrayList;

    public class myadapter extends RecyclerView.Adapter<myadapter.RecyclerViewHolder> {
        private JSONArray mlist ;//= new ArrayList<>();
        private Context mcontext;

        public myadapter(JSONArray mlist) {
            this.mlist = mlist;
            this.mcontext = mcontext;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.gridlayoutactivity, parent, false);
            return new RecyclerViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            // Bind the data from Viewholder
            // holder.images.setImageResource(courseDataArrayList.get(position).getImg1());
            try {
                JSONObject obj = mlist.getJSONObject(position);

                holder.t1.setText(obj.getString("courses"));
                holder.t2.setText(obj.getString("mentor"));
                holder.t3.setText(obj.getString("price"));
                Picasso.get().load(obj.getString("Url")).into(holder.images);

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }

        @Override
        public int getItemCount() {
            return mlist.length();
        }


        // View Holder Class to handle Recycler View.
        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            private TextView t1, t2, t3;
            private ImageView images;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                t1 = itemView.findViewById(R.id.text1);
                t2 = itemView.findViewById(R.id.text2);
                t3 = itemView.findViewById(R.id.text3);
                images = itemView.findViewById(R.id.img1);
            }

        }
    }
    
  

 ## 4.6: Now modify the Activity. Load JSON Data from the assets folder. Create an object of the RecyclerView Adapter and set it to the RecyclerView.
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










