package com.example.demo.Fetcher;

import com.example.demo.Model.Location;
import com.example.demo.Repository.CoordinatesRepository;
import com.example.demo.Repository.LocationRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@DgsComponent
public class LocationFetcher {

        Map<Float,Float> coordinates = new HashMap<>();
    public List<Location> locations = new ArrayList<>();


    private LocationRepository locationRepository;
    private final CoordinatesRepository coordinatesRepository;

    public LocationFetcher(LocationRepository locationRepository,
                           CoordinatesRepository coordinatesRepository) {
        this.locationRepository = locationRepository;
        this.coordinatesRepository = coordinatesRepository;
    }

    @DgsQuery
    public String locations() {
        locations.add(new Location(1, 12.34f, 11.34f));
        locations.add(new Location(2, 10.34f, 11.2f));
        locations.add(new Location(3, 11.34f, 11.4f));
        locations.add(new Location(4, 9.34f, 11.36f));
        locations.add(new Location(5, 15.34f, 11.38f));


        return locationRepository.saveAll(locations).toString();
    }

    @DgsQuery
   public String coordinates(){
        coordinates.put(89.98f,77.80f);
        coordinates.put(87.98f,76.80f);
        coordinates.put(90.98f,75.80f);
        coordinates.put(23.98f,74.80f);
        coordinates.put(81.98f,73.80f);

        return coordinates.toString();

    }
}







