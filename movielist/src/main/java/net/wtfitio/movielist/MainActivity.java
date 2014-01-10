package net.wtfitio.movielist;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import net.wtfitio.movielist.adapters.MovieAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by plamend on 1/10/14.
 */
public class MainActivity extends Activity {
    List<Movie> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ListView list = (ListView)findViewById(R.id.listmovie);
        Resources res = getResources();
        this.movies = new ArrayList<Movie>();
        movies = generateMovies(res);

        MovieAdapter adapter = new MovieAdapter(this,R.layout.list_movie_base,movies);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("click",String.valueOf(position));
                Intent intent = cIntent();
                intent.putExtra("position",position);

                startActivity(intent);


            }
        });


    }

    private Intent cIntent() {
        Intent intent = new Intent(this,MovieExtActivity.class);
      
        //intent.putExtra("movielist", (Serializable) movies);
        return intent;

    }

    private List<Movie> generateMovies(Resources res) {
        List<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie();
        movie1.setTitle("The Legend of Hercules");
        movie1.setYear(2014);
        movie1.setDirector("Renny Harlin");
        movie1.setDescription("The origin story of the the mythical Greek hero.");
        movie1.setPicture(res.getDrawable(R.drawable.m1));
        movies.add(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("In Bloom");
        movie2.setYear(2013);
        movie2.setDirector("Nana Ekvtimishvili");
        movie2.setDescription("Set in the Georgian capital of Tbilisi in 1992.");
        movie2.setPicture(res.getDrawable(R.drawable.m2));
        movies.add(movie2);

        Movie movie3 = new Movie();
        movie3.setTitle("The Rocket");
        movie3.setYear(2013);
        movie3.setDirector("Kim Mordaunt");
        movie3.setDescription("A boy who is believed to bring bad luck to everyone around him leads his family and two new friends through Laos to find a new home.");
        movie3.setPicture(res.getDrawable(R.drawable.m3));
        movies.add(movie3);

        return movies;
    }
}
