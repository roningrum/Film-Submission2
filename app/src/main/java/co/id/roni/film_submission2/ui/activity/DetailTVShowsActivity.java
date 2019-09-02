package co.id.roni.film_submission2.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import co.id.roni.film_submission2.R;
import co.id.roni.film_submission2.model.TvShow;
import co.id.roni.film_submission2.ui.fragment.MovieFragment;
import co.id.roni.film_submission2.ui.fragment.TVShowsFragment;

public class DetailTVShowsActivity extends AppCompatActivity {
    public static final String EXTRA_TVSHOWS = "extra_mtvshows";
    private ImageView imgPosterTVShowsDetail, imgBannerTvShowsDetail;
    private TextView tvNameTVShowsDetail, tvGenreTvShowsDetail,
            tvDurationTvShowsDetail, tvCreatorTvShowsDetail, tvSynopsisTvShowsDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshows);
        imgPosterTVShowsDetail = findViewById(R.id.img_tvshows_poster_detail);
        imgBannerTvShowsDetail = findViewById(R.id.img_detail_photo_tv_banner);
        tvNameTVShowsDetail = findViewById(R.id.tv_name_tvshows_detail);
        tvGenreTvShowsDetail = findViewById(R.id.tv_genre_tvshows_detail);
        tvDurationTvShowsDetail = findViewById(R.id.tv_duration_tvShows_item);
        tvCreatorTvShowsDetail = findViewById(R.id.tv_creator_detail);
        tvSynopsisTvShowsDetail = findViewById(R.id.tv_synopsis_tvshows_detail);

        showTvShowsDetail();

    }

    private void showTvShowsDetail() {
        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOWS);
        if (tvShow != null && getSupportActionBar() != null) {
            getSupportActionBar().setTitle(tvShow.getNameTvShow());
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            tvNameTVShowsDetail.setText(tvShow.getNameTvShow());
            tvGenreTvShowsDetail.setText(tvShow.getGenreTvShow());
            tvDurationTvShowsDetail.setText(tvShow.getDurationTvShow());
            tvCreatorTvShowsDetail.setText(tvShow.getCreatorTvShows());
            tvSynopsisTvShowsDetail.setText(tvShow.getSynopsisTvShow());

            imgPosterTVShowsDetail.setImageResource(tvShow.getPosterTvShow());
            imgBannerTvShowsDetail.setImageResource(tvShow.getPhotoTvShowBanner());
        }
    }
}
