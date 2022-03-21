package com.reto2.microservices.apigeolocation.controller;

import java.util.List;

import com.reto2.microservices.apigeolocation.dto.GeoLocationDTO;
import com.reto2.microservices.apigeolocation.services.GeoLocationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class GeoLocationController {

    private final GeoLocationService geoLocationService;

    @GetMapping("/locations")
    public ResponseEntity<List<GeoLocationDTO>> retrieveLocations(){
        try {
            List<GeoLocationDTO> locations = geoLocationService.getAll();
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<GeoLocationDTO> getLocationByBikeId(@PathVariable("id") String id) {
        try {
            GeoLocationDTO location = geoLocationService.getByBikeId(id);
            return new ResponseEntity<>(location, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @PostMapping("/locations")
    public ResponseEntity<GeoLocationDTO> createLocation(@RequestBody GeoLocationDTO newGeoLocation) {
        try {
            GeoLocationDTO location = geoLocationService.create(newGeoLocation);
            return new ResponseEntity<>(location, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error creating");
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/location-update")
    public ResponseEntity<GeoLocationDTO> updateLocation(@RequestBody GeoLocationDTO location) {
        try {
            GeoLocationDTO updatedLocation = geoLocationService.update(location);
            return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }  
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<HttpStatus> deleteLocation(@PathVariable("id") String id) {
        try {
            geoLocationService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/locations")
    public ResponseEntity<HttpStatus> deleteAllLocations() {
        try {
            geoLocationService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
