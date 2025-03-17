package com.example;

import java.util.List;

public class Main {

        public static void main(String[] args) {
            // Get the Championship Manager instance (Singleton)
            ChampionshipManager manager = ChampionshipManager.getInstance();
    
            // Create and register drivers
            Driver d1 = new Driver("Sébastien Ogier", "France", new GravelCar("Toyota", "Yaris", 300, 250));
            Driver d2 = new Driver("Kalle Rovanperä", "Finland", new AsphaltCar("Hyundai", "i20", 320, 150));
            Driver d3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Ford", "Fiesta", 290, 240));
            Driver d4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Citroen", "C3", 310, 140));
    
            manager.registerDriver(d1);
            manager.registerDriver(d2);
            manager.registerDriver(d3);
            manager.registerDriver(d4);
    
            // Create a race and record results
            RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
            race1.recordResult(d1, 1, 25);
            race1.recordResult(d2, 2, 18);
            race1.recordResult(d3, 3, 15);
            race1.recordResult(d4, 4, 12);
    
            manager.addRaceResult(race1);
    
            for (Driver driver : manager.getDriverStandings()) {
                System.out.println(driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
            }

            System.out.println("\n===== CHAMPIONSHIP LEADER =====");
            Driver leader = ChampionshipManager.getLeadingDriver();
            if (leader != null) {
                System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
            } else {
                System.out.println("No leader yet");
        }
    
            // Display championship statistics
            System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
            System.out.println("Total Drivers: " + ChampionshipManager.getInstance().getDriverStandings().size());
            System.out.println("Total Races: " + ChampionshipManager.getTotalRacesHeld());
            System.out.println("Leading Driver: " + (ChampionshipManager.getLeadingDriver() != null ? 
                    ChampionshipManager.getLeadingDriver().getName() : "No leader yet"));
            System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());
            System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        
            System.out.println("\n===== RACE RESULTS =====");
            for (RallyRaceResult race : manager.getRaces()) {
                System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
                List<Driver> raceResults = race.getResults();
                for (int i = 0; i < raceResults.size(); i++) {
                    System.out.println(" Position " + (i + 1) + ": " + raceResults.get(i).getName() + " - " + raceResults.get(i).getPoints() + " points");
                }
            }
            
            System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
            System.out.println("Gravel Car Performance: " + new GravelCar("Toyota", "Yaris", 300, 250).calculatePerformance());
            System.out.println("Asphalt Car Performance: " + new AsphaltCar("Hyundai", "i20", 320, 150).calculatePerformance());
        }
    }

