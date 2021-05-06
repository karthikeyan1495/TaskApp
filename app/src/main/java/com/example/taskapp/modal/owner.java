package com.example.taskapp.modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class owner implements Serializable {
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    @SerializedName("login")
    String login;

    @SerializedName("avatar_url")
    String avatar_url;

    @SerializedName("id")
    String id;

    @SerializedName("node_id")
    String node_id;

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @SerializedName("subscriptions_url")
    String subscriptions_url;

    @SerializedName("organizations_url")
    String organizations_url;

    @SerializedName("type")
    String type;


}
