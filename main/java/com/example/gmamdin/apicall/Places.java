package com.example.gmamdin.apicall;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Places implements Serializable{
    @SerializedName("description")
    private String description;
    @SerializedName("id")
    private Integer id;

    public Places(String description, Integer id) {
        this.description = description;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
