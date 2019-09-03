package co.id.roni.film_submission2.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import co.id.roni.film_submission2.R;
import co.id.roni.film_submission2.model.Movie;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_FILMS = "extra_movies";
    private ImageView imgPosterDetail, imgBannerDetail;
    private TextView tvNameMoviesDetail, tvGenreMoviesDetail, tvReleaseDateMoviesDetail,
            tvDurationMoviesDetail, tvDirectorMoviesDetail, tvSynopsisMoviesDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        imgPosterDetail = findViewById(R.id.img_movie_poster_detail);
        imgBannerDetail = findViewById(R.id.img_detail_photo_banner);
        tvNameMoviesDetail = findViewById(R.id.tv_name_movie_detail);
        tvGenreMoviesDetail = findViewById(R.id.tv_genre_movie_detail);
        tvReleaseDateMoviesDetail = findViewById(R.id.tv_release_time_detail);
        tvDurationMoviesDetail = findViewById(R.id.tv_duration_movie_item);
        tvDirectorMoviesDetail = findViewById(R.id.tv_director_detail);
        tvSynopsisMoviesDetail = findViewById(R.id.tv_sinopsis_detail);


        //menampilkan data detail movie
        showMovieDetail();

    }

    private void showMovieDetail() {
        Movie movie = getIntent().getParcelableExtra(EXTRA_FILMS);
        if (movie != null && getSupportActionBar() != null) {
            getSupportActionBar().setTitle(movie.getNameMovie());
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            tvNameMoviesDetail.setText(movie.getNameMovie());
            tvDurationMoviesDetail.setText(movie.getDurationMovie());
            tvGenreMoviesDetail.setText(movie.getGenreMovie());
            tvReleaseDateMoviesDetail.setText(movie.getReleaseDateMovie());
            tvDirectorMoviesDetail.setText(movie.getDirectorMovie());
            tvSynopsisMoviesDetail.setText(movie.getSynopsisMovie());

            Glide.with(this).load(movie.getPosterMovie()).into(imgPosterDetail);
            Glide.with(this).load(movie.getPhotoMovieBanner()).into(imgBannerDetail);

        }
    }

}
