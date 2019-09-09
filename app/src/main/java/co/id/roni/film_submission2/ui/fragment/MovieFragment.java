package co.id.roni.film_submission2.ui.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.id.roni.film_submission2.R;
import co.id.roni.film_submission2.adapter.MovieListAdapter;
import co.id.roni.film_submission2.model.Movie;
import co.id.roni.film_submission2.ui.activity.DetailMovieActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private String[] dataNamaFilm;
    private String[] dataGenreFilm;
    private String[] dataDirectorFilm;
    private String[] dataDurationFilm;
    private String[] dataReleaseDateFilm;
    private String[] dataSinopsisFilm;
    private TypedArray dataPhotoFilm;
    private TypedArray dataPhotoBannerFilm;

    private ArrayList<Movie> movies;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvMovies = view.findViewById(R.id.rv_movies);

        prepareItem();
        addItem();

        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieListAdapter movieListAdapter = new MovieListAdapter(movies);
        rvMovies.setAdapter(movieListAdapter);
        movieListAdapter.setOnItemClickCallback(this::showIntentMovieDetail);
    }

    private void showIntentMovieDetail(Movie movieData) {
        Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
        intent.putExtra(DetailMovieActivity.EXTRA_FILMS, movieData);
        startActivity(intent);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataNamaFilm.length; i++) {
            Movie movie = new Movie();
            movie.setNameMovie(dataNamaFilm[i]);
            movie.setPosterMovie(dataPhotoFilm.getResourceId(i, -1));
            movie.setGenreMovie(dataGenreFilm[i]);
            movie.setDirectorMovie(dataDirectorFilm[i]);
            movie.setDurationMovie(dataDurationFilm[i]);
            movie.setSynopsisMovie(dataSinopsisFilm[i]);
            movie.setReleaseDateMovie(dataReleaseDateFilm[i]);
            movie.setPhotoMovieBanner(dataPhotoBannerFilm.getResourceId(i, -1));
            movies.add(movie);
        }
    }

    private void prepareItem() {
        dataNamaFilm = getResources().getStringArray(R.array.data_name_movie);
        dataGenreFilm = getResources().getStringArray(R.array.data_genre_movie);
        dataSinopsisFilm = getResources().getStringArray(R.array.data_synopsis_movies);
        dataDirectorFilm = getResources().getStringArray(R.array.data_director_movie);
        dataReleaseDateFilm = getResources().getStringArray(R.array.data_movie_release);
        dataDurationFilm = getResources().getStringArray(R.array.data_duration_time);
        dataPhotoBannerFilm = getResources().obtainTypedArray(R.array.data_img_movie_banner);
        dataPhotoFilm = getResources().obtainTypedArray(R.array.data_image_movie);
    }
}
