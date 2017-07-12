package com.example.bhavyesharma.jsonretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Network.APIinterface;

import Network.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Post> posts;
    ListView postListView;
    ArrayAdapter<String> adapter;
    ArrayList<String> postName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postListView = (ListView) findViewById(R.id.postListView);
        posts = new ArrayList<>();
        postName=new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, postName);
        postListView.setAdapter(adapter);
        fetchCourses();
        postListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Object o=postListView.getItemAtPosition(i);
            }
        });
    }


    private void fetchCourses() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIinterface apiInterface = retrofit.create(APIinterface.class);
        Call<ArrayList<Post>> call = apiInterface.getPosts();
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                ArrayList<Post> post = response.body();
                onDownloadComplete(post);

            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });


    }

    public void onDownloadComplete(ArrayList<Post> coursesList) {
        posts.clear();
        posts.addAll(coursesList);
        for (int i = 0; i < posts.size(); i++) {
            postName.add(posts.get(i).getTitle());
        }
        adapter.notifyDataSetChanged();


    }
}
