package com.example.taskapp.modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataModalList implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.example.taskapp.modal.owner getOwner() {
        return owner;
    }

    public void setOwner(com.example.taskapp.modal.owner owner) {
        this.owner = owner;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @SerializedName("id")
    String id;
    @SerializedName("full_name")
    String full_name;
    @SerializedName("name")
    String name;

    @SerializedName("owner")
    owner owner;

    @SerializedName("html_url")
    String html_url;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("description")
    String description;



}
