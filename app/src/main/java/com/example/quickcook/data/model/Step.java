
package com.example.quickcook.data.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step {

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("step")
    @Expose
    private String step;
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    @SerializedName("equipment")
    @Expose
    private List<Equipment> equipment = new ArrayList<Equipment>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Step() {
    }

    /**
     * 
     * @param number
     * @param ingredients
     * @param equipment
     * @param step
     */
    public Step(Integer number, String step, List<Ingredient> ingredients, List<Equipment> equipment) {
        super();
        this.number = number;
        this.step = step;
        this.ingredients = ingredients;
        this.equipment = equipment;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

}
