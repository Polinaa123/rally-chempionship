package com.example;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RallyRaceResult implements RaceResult{
    private String raceName;
    private String location;
    private Map<Driver, Integer> results = new HashMap<>();

    public RallyRaceResult(String raceName, String location){
        this.raceName= raceName;
        this.location= location;
    }

    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points){
        results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return results.getOrDefault(driver, 0);
    }

    @Override
    public List<Driver> getResults(){
        List<Driver> sortedResults = new ArrayList<>(results.keySet());
        sortedResults.sort((d1, d2) -> results.get(d2) - results.get(d1));
        return sortedResults;
    }
}
