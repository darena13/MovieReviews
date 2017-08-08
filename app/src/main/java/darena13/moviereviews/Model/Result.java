package darena13.moviereviews.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by darena13 on 08.08.2017.
 */

public class Result {
    @SerializedName("display_title")
    @Expose
    private String displayTitle;

    @SerializedName("sort_name")
    @Expose
    private String sortName;

    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;

    @SerializedName("critics_pick")
    @Expose
    private String criticsPick;

    @SerializedName("byline")
    @Expose
    private String byline;

    @SerializedName("headline")
    @Expose
    private String headline;

    @SerializedName("capsule_review")
    @Expose
    private String capsuleReview;

    @SerializedName("summary_short")
    @Expose
    private String summaryShort;

    @SerializedName("publication_date")
    @Expose
    private String publicationDate;

    @SerializedName("opening_date")
    @Expose
    private String openingDate;

    @SerializedName("date_updated")
    @Expose
    private String dateUpdated;

    @SerializedName("link")
    @Expose
    private Link link;

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getCriticsPick() {
        return criticsPick;
    }

    public void setCriticsPick(String criticsPick) {
        this.criticsPick = criticsPick;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getCapsuleReview() {
        return capsuleReview;
    }

    public void setCapsuleReview(String capsuleReview) {
        this.capsuleReview = capsuleReview;
    }

    public String getSummaryShort() {
        return summaryShort;
    }

    public void setSummaryShort(String summaryShort) {
        this.summaryShort = summaryShort;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
