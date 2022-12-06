package com.adesso.tireManagement.model;

import javax.persistence.*;

/**
 * The entity representation of a tire.
 */
@Entity
public class Tire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer width;
    private Integer heightWidthRatio;
    @Enumerated(EnumType.STRING)
    private TireDesignType designType;
    private Integer diameter;
    private Integer loadIndex;
    private Character speedIndex;
    private String imagePath;

    /**
     * Creates a new instance of a tire.
     */
    public Tire() {
    }

    /**
     * Creates a new instance of a tire with parameters.
     */
    public Tire(Integer width, Integer heightWidthRatio, TireDesignType designType, Integer diameter, Integer loadIndex,
                Character speedIndex) {
        this.width = width;
        this.heightWidthRatio = heightWidthRatio;
        this.designType = designType;
        this.diameter = diameter;
        this.loadIndex = loadIndex;
        this.speedIndex = speedIndex;
    }

    /**
     * Gets the id of this tire.
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the width (in millimeters) of this tire.
     * @return width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the width (in millimeters) of this tire.
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Gets the height width of the ratio in percentage.
     * @return heightWidthRatio
     */
    public Integer getHeightWidthRatio() {
        return heightWidthRatio;
    }

    /**
     * Sets the ratio between height and width of this tire in percentage.
     * @param heightWidthRatio
     */
    public void setHeightWidthRatio(Integer heightWidthRatio) {
        this.heightWidthRatio = heightWidthRatio;
    }

    /**
     * Gets the design type of this tire.
     * @return designType
     */
    public TireDesignType getDesignType() {
        return designType;
    }

    /**
     * Sets the design type of this tire.
     * @param designType
     */
    public void setDesignType(TireDesignType designType) {
        this.designType = designType;
    }

    /**
     * Gets the diameter of this tire.
     * @return diameter
     */
    public Integer getDiameter() {
        return diameter;
    }

    /**
     * Sets the diameter of this tire.
     * @param diameter
     */
    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    /**
     * Gets the load index of this tire.
     * @return loadIndex
     */
    public Integer getLoadIndex() {
        return loadIndex;
    }

    /**
     * Sets the load index of this tire.
     * @param loadIndex
     */
    public void setLoadIndex(Integer loadIndex) {
        this.loadIndex = loadIndex;
    }

    /**
     * Gets the speed index of this tire.
     */
    public Character getSpeedIndex() {
        return speedIndex;
    }

    /**
     * Sets the speed index of this tire.
     * @param speedIndex
     */
    public void setSpeedIndex(Character speedIndex) {
        this.speedIndex = speedIndex;
    }

    /**
     * Gets the image path.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets the image path.
     * @param imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
