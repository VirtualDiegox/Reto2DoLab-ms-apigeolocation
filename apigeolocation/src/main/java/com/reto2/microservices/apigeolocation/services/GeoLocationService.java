package com.reto2.microservices.apigeolocation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.reto2.microservices.apigeolocation.dto.GeoLocationDTO;
import com.reto2.microservices.apigeolocation.model.GeoLocation;
import com.reto2.microservices.apigeolocation.repository.GeoLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoLocationService {
    @Autowired
    private GeoLocationRepository geoLocationRepository;

    public List<GeoLocationDTO> getAll() {
        try {
            List<GeoLocationDTO> locations = new ArrayList<>();
            for (GeoLocation g : geoLocationRepository.findAll()) {
                locations.add(new GeoLocationDTO(g.getBikeId(),
                        g.getLongitude(),
                        g.getLatitude()));
            }
            return locations;
        } catch (Exception e) {
            throw e;
        }
    }

    public GeoLocationDTO getByBikeId(String bikeId) {
        try {
            Optional<GeoLocation> locationData = geoLocationRepository.findByBikeId(bikeId);
            if (locationData.isPresent()) {
                GeoLocation location = locationData.get();
                GeoLocationDTO locationDTO = new GeoLocationDTO(
                        location.getBikeId(),
                        location.getLongitude(),
                        location.getLatitude());
                return locationDTO;
            } else {
                return new GeoLocationDTO();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public GeoLocationDTO create(GeoLocationDTO geoLocation) {
        try {
            Optional<GeoLocation> existingLocationData = geoLocationRepository.findByBikeId(geoLocation.getBikeId());
            if (!existingLocationData.isPresent()) {
                GeoLocation location = geoLocationRepository.save(new GeoLocation(
                        geoLocation.getBikeId(),
                        geoLocation.getLatitude(),
                        geoLocation.getLongitude()));
                GeoLocationDTO geoLocationDTO = new GeoLocationDTO(
                        location.getBikeId(),
                        location.getLatitude(),
                        location.getLongitude());
                return geoLocationDTO;
            } else {
                return new GeoLocationDTO();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public GeoLocationDTO update(GeoLocationDTO newLocation) {
        try {
            Optional<GeoLocation> existingLocationData = geoLocationRepository.findByBikeId(newLocation.getBikeId());
            if (existingLocationData.isPresent()) {
                GeoLocation oldLocationData = existingLocationData.get();
                oldLocationData.setLongitude(newLocation.getLongitude());
                oldLocationData.setLatitude(newLocation.getLatitude());
                GeoLocation updatedLocation = geoLocationRepository.save(oldLocationData);
                GeoLocationDTO updatedLocationDTO = new GeoLocationDTO(
                        updatedLocation.getBikeId(),
                        updatedLocation.getLongitude(),
                        updatedLocation.getLatitude());
                return updatedLocationDTO;
            }else {
                return new GeoLocationDTO();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(String id){
        try {
            geoLocationRepository.deleteByBikeId(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteAll(){
        try {
            geoLocationRepository.deleteAll();
        } catch (Exception e) {
            throw e;
        }
    }



    
}
