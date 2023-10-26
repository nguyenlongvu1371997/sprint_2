package com.example.backendchillvie.projection;

public interface IMovieProjection {
    Long getId();
    String getName();
    String getDirector();
    String getActor();
    String getReleaseDate();
    String getNote();
    String getTrailer();
    Long getShowingTime();
    String getLabel();
    Boolean getIsShowing();
    String getPicture();

}
