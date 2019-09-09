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
import co.id.roni.film_submission2.model.TvShow;

public class TVShowListAdapter extends RecyclerView.Adapter<TVShowListAdapter.TvShowViewHolder> {
    private ArrayList<TvShow> tvShows;
    private TVShowListAdapter.OnItemClickCallback onItemClickCallback;

    public TVShowListAdapter(ArrayList<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_tv_shows, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        holder.bindMovies(tvShows.get(position));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name_tvshows_item)
        TextView tvNameTVItem;
        @BindView(R.id.tv_genre_tv_shows_item)
        TextView tvGenreTVShow;
        @BindView(R.id.img_tv_shows_item)
        ImageView imgTvShowItem;


        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindMovies(TvShow tvShow) {
            tvNameTVItem.setText(tvShow.getNameTvShow());
            tvGenreTVShow.setText(tvShow.getGenreTvShow());
            Glide.with(itemView.getContext()).load(tvShow.getPosterTvShow()).into(imgTvShowItem);
            itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(tvShows.get(getAdapterPosition())));
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvShow tvShow);
    }
}
