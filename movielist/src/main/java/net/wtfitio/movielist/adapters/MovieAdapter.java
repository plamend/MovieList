package net.wtfitio.movielist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.wtfitio.movielist.Movie;
import net.wtfitio.movielist.R;

import java.util.List;

/**
 * Created by plamend on 1/10/14.
 */
public class MovieAdapter extends ArrayAdapter<Movie> {
    public MovieAdapter(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            Context context = getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_movie_base,parent,false);
               MovieHolder holder = InitializeHolder(convertView);
            convertView.setTag(holder);
        }
        Movie movie = getItem(position);
        MovieHolder holder = (MovieHolder) convertView.getTag();
        String Title = movie.getTitle();
        holder.movieTitle.setText(Title);

        int year = movie.getYear();
        holder.prodYear.setText(String.format("%d",year));

        return convertView;
    }

    private MovieHolder InitializeHolder(View convertView) {
        MovieHolder holder = new MovieHolder();
        holder.movieTitle = (TextView) convertView.findViewById(R.id.title_movie);
        holder.prodYear = (TextView) convertView.findViewById(R.id.prod_year);
        return holder;
    }

    private class MovieHolder {
        private TextView movieTitle;
        private TextView prodYear;
    }
}
