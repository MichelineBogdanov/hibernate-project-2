package org.hibernate_project_2.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.hibernate_project_2.entity.Rating;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getName();
    }

    @Override
    public Rating convertToEntityAttribute(String dbRating) {
        Rating[] values = Rating.values();
        for (Rating rating : values) {
            if (rating.getName().equals(dbRating)) {
                return rating;
            }
        }
        return null;
    }
}
