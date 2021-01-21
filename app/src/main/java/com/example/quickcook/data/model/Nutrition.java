package com.example.quickcook.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Nutrition {
    @SerializedName("nutrients")
    @Expose
    List<Nutrient> nutrients;

    public Nutrition(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }
}
