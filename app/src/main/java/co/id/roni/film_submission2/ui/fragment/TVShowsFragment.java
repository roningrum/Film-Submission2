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
import co.id.roni.film_submission2.adapter.TVShowListAdapter;
import co.id.roni.film_submission2.model.TvShow;
import co.id.roni.film_submission2.ui.activity.DetailTVShowsActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowsFragment extends Fragment {
    private String[] dataNameTVShow;
    private String[] dataGenreTvShow;
    private String[] dataCreatorTvShow;
    private String[] dataDurationTvShow;
    private String[] dataSinopsisTvShow;
    private TypedArray dataPosterTvShow;
    private TypedArray dataPhotoBannerTvShow;
    private ArrayList<TvShow> tvShows;

    public TVShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvseries, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvTvShows = view.findViewById(R.id.rv_tv_shows);
        prepareItem();
        addItem();

        rvTvShows.setLayoutManager(new LinearLayoutManager(getContext()));
        TVShowListAdapter tvListAdapter = new TVShowListAdapter(tvShows);
        rvTvShows.setAdapter(tvListAdapter);
        tvListAdapter.setOnItemClickCallback(new TVShowListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TvShow tvShow) {
                showIntentTvShowsDetail(tvShow);
            }
        });
    }

    private void showIntentTvShowsDetail(TvShow tvShow){
        Intent intent = new Intent(getActivity(), DetailTVShowsActivity.class);
        intent.putExtra(DetailTVShowsActivity.EXTRA_TVSHOWS, tvShow);
        startActivity(intent);
    }

    private void addItem() {
        tvShows = new ArrayList<>();
        for (int i = 0; i < dataNameTVShow.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setNameTvShow(dataNameTVShow[i]);
            tvShow.setGenreTvShow(dataGenreTvShow[i]);
            tvShow.setCreatorTvShows(dataCreatorTvShow[i]);
            tvShow.setSynopsisTvShow(dataSinopsisTvShow[i]);
            tvShow.setDurationTvShow(dataDurationTvShow[i]);
            tvShow.setPhotoTvShowBanner(dataPhotoBannerTvShow.getResourceId(i, -1));
            tvShow.setPosterTvShow(dataPosterTvShow.getResourceId(i, -1));

            tvShows.add(tvShow);
        }
    }

    private void prepareItem() {
        dataNameTVShow = getResources().getStringArray(R.array.data_name_tv_shows);
        dataGenreTvShow = getResources().getStringArray(R.array.data_genre_tv_shows);
        dataCreatorTvShow = getResources().getStringArray(R.array.data_creator_tv_shows);
        dataDurationTvShow = getResources().getStringArray(R.array.data_duration_tv_shows_episode);
        dataPosterTvShow = getResources().obtainTypedArray(R.array.data_image_tv_shows);
        dataPhotoBannerTvShow = getResources().obtainTypedArray(R.array.data_img_tv_shows_banner);
        dataSinopsisTvShow = getResources().getStringArray(R.array.data_synopsis_tv_shows);
    }
}
