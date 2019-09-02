package co.id.roni.film_submission2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String nameTvShow;
    private String genreTvShow;
    private String durationTvShow;
    private String synopsisTvShow;
    private String creatorTvShows;
    private int PhotoTvShowBanner;
    private int PosterTvShow;


    public String getNameTvShow() {
        return nameTvShow;
    }

    public void setNameTvShow(String nameTvShow) {
        this.nameTvShow = nameTvShow;
    }

    public String getGenreTvShow() {
        return genreTvShow;
    }

    public void setGenreTvShow(String genreTvShow) {
        this.genreTvShow = genreTvShow;
    }

    public String getDurationTvShow() {
        return durationTvShow;
    }

    public void setDurationTvShow(String durationTvShow) {
        this.durationTvShow = durationTvShow;
    }

    public String getSynopsisTvShow() {
        return synopsisTvShow;
    }

    public void setSynopsisTvShow(String synopsisTvShow) {
        this.synopsisTvShow = synopsisTvShow;
    }

    public String getCreatorTvShows() {
        return creatorTvShows;
    }

    public void setCreatorTvShows(String creatorTvShows) {
        this.creatorTvShows = creatorTvShows;
    }

    public int getPhotoTvShowBanner() {
        return PhotoTvShowBanner;
    }

    public void setPhotoTvShowBanner(int photoTvShowBanner) {
        PhotoTvShowBanner = photoTvShowBanner;
    }

    public int getPosterTvShow() {
        return PosterTvShow;
    }

    public void setPosterTvShow(int posterTvShow) {
        PosterTvShow = posterTvShow;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nameTvShow);
        dest.writeString(this.genreTvShow);
        dest.writeString(this.durationTvShow);
        dest.writeString(this.synopsisTvShow);
        dest.writeString(this.creatorTvShows);
        dest.writeInt(this.PhotoTvShowBanner);
        dest.writeInt(this.PosterTvShow);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.nameTvShow = in.readString();
        this.genreTvShow = in.readString();
        this.durationTvShow = in.readString();
        this.synopsisTvShow = in.readString();
        this.creatorTvShows = in.readString();
        this.PhotoTvShowBanner = in.readInt();
        this.PosterTvShow = in.readInt();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
