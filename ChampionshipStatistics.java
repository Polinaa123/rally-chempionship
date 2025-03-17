package com.example;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;

class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers){
        return drivers.stream().mapToInt(Driver::getPoints).average().orElse(0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers){
        if (drivers == null || drivers.isEmpty()) {
            return "No data available";
        }
        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver driver : drivers){
            countryPoints.put(driver.getCountry(), countryPoints.getOrDefault(driver.getCountry(), 0)+ driver.getPoints());
        }
        return Collections.max(countryPoints.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRacesHeld();
    }
}
