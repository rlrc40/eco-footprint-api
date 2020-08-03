package com.learninspringboot.ecofootprintapi.model;

import org.springframework.data.annotation.Id;

public class EcoAction {

    @Id
    public String id;

    public String actionId;

    public String description;

    public String depends;

    public Double co2e;

    public Integer categoryType;

    public EcoAction(String description, String depends, Double co2e, Integer categoryType) {
        this.description = description;
        this.depends = depends;
        this.co2e = co2e;
        this.categoryType = categoryType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActionId() {
         return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepends() {
        return depends;
    }

    public void setDepends(String depends) {
        this.depends = depends;
    }

    public Double getCo2e() {
        return co2e;
    }

    public void setCo2e(Double co2e) {
        this.co2e = co2e;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) { this.categoryType = categoryType; }


}
