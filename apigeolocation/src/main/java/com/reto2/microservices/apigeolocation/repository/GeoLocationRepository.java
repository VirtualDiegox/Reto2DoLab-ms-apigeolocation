package com.reto2.microservices.apigeolocation.repository;

import java.util.Optional;

import com.reto2.microservices.apigeolocation.model.GeoLocation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeoLocationRepository extends MongoRepository <GeoLocation, String>{
    Optional<GeoLocation> findByBikeId(String bikeId);
    void deleteByBikeId(String bikeId);
}
