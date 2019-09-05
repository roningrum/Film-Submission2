package co.id.roni.film_submission2.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.id.roni.film_submission2.R;
import co.id.roni.film_submission2.model.TvShow;

public class DetailTVShowsActivity extends AppCompatActivity {

    @BindView(R.id.tv_name_tvshows_detail)
    TextView tvNameTVShowsDetail;
    @BindView(R.id.tv_genre_tvshows_detail)
    TextView tvGenreTvShowsDetail;
    @BindView(R.id.tv_duration_tvShows_item)
    TextView tvDurationTvShowsDetail;
    @BindView(R.id.tv_creator_detail)
    TextView tvCreatorTvShowsDetail;
    @BindView(R.id.tv_synopsis_tvshows_detail)
    TextView tvSynopsisTvShowsDetail;
    @BindView(R.id.img_tvshows_poster_detail)
    ImageView imgPosterTVShowsDetail;
    @BindView(R.id.img_detail_photo_tv_banner)
    ImageView imgBannerTvShowsDetail;

    public static final String EXTRA_TVSHOWS = "extra_mtvshows";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshows);
        ButterKnife.bind(this);
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

            Glide.with(this).load(tvShow.getPosterTvShow()).into(imgPosterTVShowsDetail);
            Glide.with(this).load(tvShow.getPhotoTvShowBanner()).into(imgBannerTvShowsDetail);

        }
    }
}
