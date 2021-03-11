package com.example.volleycrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleycrud.adapter.UserAdapter;
import com.example.volleycrud.model.UserInnforamtion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    private  static  final  String URL = "https://api.github.com/users";

    List<UserInnforamtion> userInnforamtionList = new ArrayList<>();
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.d("Response", response.toString());

                for(int i =0; i<response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        UserInnforamtion userInnforamtion = new UserInnforamtion();
                        userInnforamtion.setLogin(jsonObject.getString("login"));
                        userInnforamtion.setAvatarUrl(jsonObject.getString("avatar_url"));


                        userInnforamtionList.add(userInnforamtion);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                userAdapter = new UserAdapter(MainActivity.this,userInnforamtionList);
                recyclerView.setAdapter(userAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });




        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    }






    }
