package com.samsolution.vpngatedesign.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Result {
    @SerializedName("results")
    @Expose
    private ServerInfo results = null;

    public ServerInfo getResults() {
        return results;
    }

    public void setResults(ServerInfo results) {
        this.results = results;
    }
}
