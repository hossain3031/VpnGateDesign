package com.samsolution.vpngatedesign.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ServerResponse{

    @SerializedName("HostName")
    private String hostname;
    @SerializedName("IP")
    private String ip;
    @SerializedName("Score")
    private String score;
    @SerializedName("Latency")
    private String latency;
    @SerializedName("Speed")
    private String speed;
    @SerializedName("CountryLong")
    private String countryLong;
    @SerializedName("CountryShort")
    private String countryShort;


    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCountryLong() {
        return countryLong;
    }

    public void setCountryLong(String countryLong) {
        this.countryLong = countryLong;
    }

    public String getCountryShort() {
        return countryShort;
    }

    public void setCountryShort(String countryShort) {
        this.countryShort = countryShort;
    }
}
