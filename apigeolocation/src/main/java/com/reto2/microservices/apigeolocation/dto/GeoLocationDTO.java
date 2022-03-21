package com.reto2.microservices.apigeolocation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocationDTO {
    private String bikeId;
    private Long latitude;
    private Long longitude;
}
