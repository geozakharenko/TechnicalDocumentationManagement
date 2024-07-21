package com.zakharenko.TechnicalDocumentationManagement.models;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    public Equipment(String modelName, String serialNumber, String imageUrl, String type) {
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.imageUrl = imageUrl;
        this.type = type;
    }
    public Equipment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String pathToImage) {
        this.imageUrl = pathToImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
