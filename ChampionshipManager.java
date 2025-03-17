package com.example;

import java.util.List;
import java.util.ArrayList;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers= new ArrayList<>();
    private List<RallyRaceResult> races= new ArrayList<>();
    private static int totalDrivers= 0;
    private static int totalRaces= 0;

    private ChampionshipManager(){}

    public static ChampionshipManager getInstance(){
        if (instance==null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result){
        races.add(result);
        List<Driver> results = result.getResults();

        int[] pointsDistribution = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        for (int i = 0; i < results.size() && i < pointsDistribution.length; i++) {
            Driver driver = results.get(i);
            driver.addPoints(pointsDistribution[i]);
        }
        totalRaces++;
    }

    public List<Driver> getDriverStandings(){
        drivers.sort((d1,d2) -> d2.getPoints() - d1.getPoints());
        return drivers;
    }

    public static Driver getLeadingDriver(){
        if (instance==null || instance.drivers.isEmpty()){
            return null;
        }
        instance.drivers.sort((d1,d2) -> d2.getPoints() - d1.getPoints());
        return instance.drivers.get(0);
    }

    public static int getTotalChampionshipPoints(){
        if (instance == null) {
            return 0;
        }
        int points = 0;
        for (Driver driver : instance.drivers) {
            points += driver.getPoints();
        }
        return points;
    }

    public static int getTotalDrivers(){
        return totalDrivers;
    }

    public static int getTotalRacesHeld(){
        return totalRaces;
    }

    public List<RallyRaceResult> getRaces() {
        return races;
    }    
}