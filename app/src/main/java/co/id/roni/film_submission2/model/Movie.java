package co.id.roni.film_submission2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String nameMovie;
    private String genreMovie;
    private String durationMovie;
    private String synopsisMovie;
    private String directorMovie;
    private String releaseDateMovie;
    private int PhotoMovieBanner;
    private int PosterMovie;


    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }

    public String getDurationMovie() {
        return durationMovie;
    }

    public void setDurationMovie(String durationMovie) {
        this.durationMovie = durationMovie;
    }

    public String getSynopsisMovie() {
        return synopsisMovie;
    }

    public void setSynopsisMovie(String synopsisMovie) {
        this.synopsisMovie = synopsisMovie;
    }

    public String getDirectorMovie() {
        return directorMovie;
    }

    public void setDirectorMovie(String directorMovie) {
        this.directorMovie = directorMovie;
    }

    public String getReleaseDateMovie() {
        return releaseDateMovie;
    }

    public void setReleaseDateMovie(String releaseDateMovie) {
        this.releaseDateMovie = releaseDateMovie;
    }

    public int getPhotoMovieBanner() {
        return PhotoMovieBanner;
    }

    public void setPhotoMovieBanner(int photoMovieBanner) {
        PhotoMovieBanner = photoMovieBanner;
    }

    public int getPosterMovie() {
        return PosterMovie;
    }

    public void setPosterMovie(int posterMovie) {
        PosterMovie = posterMovie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nameMovie);
        dest.writeString(this.genreMovie);
        dest.writeString(this.durationMovie);
        dest.writeString(this.synopsisMovie);
        dest.writeString(this.directorMovie);
        dest.writeString(this.releaseDateMovie);
        dest.writeInt(this.PhotoMovieBanner);
        dest.writeInt(this.PosterMovie);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.nameMovie = in.readString();
        this.genreMovie = in.readString();
        this.durationMovie = in.readString();
        this.synopsisMovie = in.readString();
        this.directorMovie = in.readString();
        this.releaseDateMovie = in.readString();
        this.PhotoMovieBanner = in.readInt();
        this.PosterMovie = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
