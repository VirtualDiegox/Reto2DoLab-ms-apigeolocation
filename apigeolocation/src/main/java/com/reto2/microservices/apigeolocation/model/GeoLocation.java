package com.reto2.microservices.apigeolocation.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "locations")
public class GeoLocation {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    @NotBlank(message = "BikeId is required")
    private String bikeId;
    @NotBlank(message = "Longitude is required")
    private Long longitude;
    @NotBlank(message = "Latitude is required")
    private Long latitude;

    public GeoLocation(String bikeId, Long longitude, Long latitude) {
        this.bikeId = bikeId;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
