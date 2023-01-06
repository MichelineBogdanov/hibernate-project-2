package org.hibernate_project_2.entity;

public enum SpecialFeatures {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted scenes"),
    BEHIND_THE_SCENES("Behind the scenes");

    private String name;

    SpecialFeatures(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
