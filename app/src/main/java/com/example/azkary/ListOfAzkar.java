package com.example.azkary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListOfAzkar {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content")
    @Expose
    private List<AzkarContent> content = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AzkarContent> getContent() {
        return content;
    }

    public void setContent(List<AzkarContent> content) {
        this.content = content;
    }
}
