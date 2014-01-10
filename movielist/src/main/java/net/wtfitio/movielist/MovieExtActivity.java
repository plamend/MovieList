package net.wtfitio.movielist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by plamend on 1/10/14.
 */
public class MovieExtActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_movie_ext);
        ImageView image = (ImageView)findViewById(R.id.image);
        TextView  direct = (TextView)findViewById(R.id.direct);
        TextView descript = (TextView)findViewById(R.id.descript);
        Intent intent = getIntent();
        List<Movie> movies = (List<Movie>) intent.getParcelableExtra("m");
        int position = intent.getIntExtra("position",0);
        Movie movie = new Movie();
        movie = movies.get(position);
        //image.setImageResource(movie.getPicture().);
        direct.setText(movie.getDirector());
        descript.setText(movie.getDescription());
    }
}
