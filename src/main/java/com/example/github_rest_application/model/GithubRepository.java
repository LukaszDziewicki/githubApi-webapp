package com.example.github_rest_application.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GithubRepository {

    @SerializedName("full_name")
    @Expose
    private String fullName;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("clone_url")
    @Expose
    private String cloneUrl;

    @SerializedName("subscribers_count")
    @Expose
    private Integer stars;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Repository {" +
                "fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", cloneUrl='" + cloneUrl + '\'' +
                ", stars=" + stars +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

