package org.hibernate_project_2.entity;

import static java.util.Objects.isNull;

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

    public static SpecialFeatures getFeatureByValue(String name) {
        if (!(isNull(name) || name.isEmpty())) {
            SpecialFeatures[] features = SpecialFeatures.values();
            for (SpecialFeatures feature : features) {
                if (feature.name.equals(name)) {
                    return feature;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
