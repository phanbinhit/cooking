package com.example.quickcook.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrient {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("percentOfDailyNeeds")
    @Expose
    private Double percentOfDailyNeeds;

    /**
     * No args constructor for use in serialization
     */
    public Nutrient() {
    }

    /**
     * @param amount
     * @param unit
     * @param percentOfDailyNeeds
     * @param title
     */
    public Nutrient(String title, Double amount, String unit, Double percentOfDailyNeeds) {
        super();
        this.title = title;
        this.amount = amount;
        this.unit = unit;
        this.percentOfDailyNeeds = percentOfDailyNeeds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPercentOfDailyNeeds() {
        return percentOfDailyNeeds;
    }

    public void setPercentOfDailyNeeds(Double percentOfDailyNeeds) {
        this.percentOfDailyNeeds = percentOfDailyNeeds;
    }

}