package edu.upc.dsa.models;

public class Badge {
    private String name;
    private String iconUrl;

    // Constructor
    public Badge(String name, String iconUrl) {
        this.name = name;
        this.iconUrl = iconUrl;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Badge() {
    }
}
