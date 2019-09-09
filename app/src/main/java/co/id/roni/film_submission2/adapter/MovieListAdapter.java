package co.id.roni.film_submission2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.id.roni.film_submission2.R;
import co.id.roni.film_submission2.model.Movie;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Movie> movies;
    private MovieListAdapter.OnItemClickCallback onItemClickCallback;

    public MovieListAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bindMovies(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name_movie_item)
        TextView tvNameMovieItem;
        @BindView(R.id.tv_genre_movie_item)
        TextView tvGenreMovie;
        @BindView(R.id.img_movie_item)
        ImageView imgMovieItem;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindMovies(Movie movie) {
            tvNameMovieItem.setText(movie.getNameMovie());
            tvGenreMovie.setText(movie.getGenreMovie());
            Glide.with(itemView.getContext()).load(movie.getPosterMovie()).into(imgMovieItem);
            itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(movies.get(getAdapterPosition())));
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie movieData);
    }
}
