package Day5;

public class SeedNumberCalculator {

    private double minValue;

    public SeedNumberCalculator(ListOfMaps listOfMaps) {
        this.minValue = Integer.MAX_VALUE;
        System.out.println("seed to soil");
        for (Seed seed : listOfMaps.getSeedList()) {
            double tempNr = seed.getSeedNumber();
            for (SeedToSoil seedToSoil : listOfMaps.getSeedToSoilList()) {
                seed.setSeedNumber(seedToSoil.convertToDestination(seed.getSeedNumber()));
                if (tempNr != seed.getSeedNumber()) {
                    System.out.println("Seed number changed to : " + seed.getSeedNumber() + " från " +tempNr );
                    break;
                }
            }
        }
        System.out.println("soil to fert");
        for (Seed seed : listOfMaps.getSeedList()) {
            double tempNr = seed.getSeedNumber();
            for (SoilToFertilizer soilToFertilizer : listOfMaps.getSoilToFertilizerList()) {
                seed.setSeedNumber(soilToFertilizer.convertToDestination(seed.getSeedNumber()));
                if (tempNr != seed.getSeedNumber()) {
                    System.out.println("Seed number changed to : " + seed.getSeedNumber() + " från " +tempNr );
                    break;
                }
            }
        }
        System.out.println("fert to water");
        for (Seed seed : listOfMaps.getSeedList()) {
            double tempNr = seed.getSeedNumber();
            for (FertilizerToWater fertilizerToWater : listOfMaps.getFertilizerToWaterList()) {
                seed.setSeedNumber(fertilizerToWater.convertToDestination(seed.getSeedNumber()));
                if (tempNr != seed.getSeedNumber()) {
                    System.out.println("Seed number changed to : " + seed.getSeedNumber() + " från " +tempNr );
                    break;
                }
            }
        }
        System.out.println("water to light");
        for (Seed seed : listOfMaps.getSeedList()) {
            double tempNr = seed.getSeedNumber();
            for (WaterToLight waterToLight : listOfMaps.getWaterToLightList()) {
                seed.setSeedNumber(waterToLight.convertToDestination(seed.getSeedNumber()));
                if (tempNr != seed.getSeedNumber()) {
                    System.out.println("Seed number changed to : " + seed.getSeedNumber() + " från " +tempNr );
                    break;
                }
            }
        }
        System.out.println("light to temp");
        for (Seed seed : listOfMaps.getSeedList()) {
            double tempNr = seed.getSeedNumber();
            for (LightToTemperature lightToTemperature : listOfMaps.getLightToTemperatureList()) {
                seed.setSeedNumber(lightToTemperature.convertToDestination(seed.getSeedNumber()));
                if (tempNr != seed.getSeedNumber()) {
                    System.out.println("Seed number changed to : " + seed.getSeedNumber() + " från " +tempNr );
                    break;
                }
            }
        }

        System.out.println("temp to humid");

        for (Seed seed : listOfMaps.getSeedList()) {
            double tempNr = seed.getSeedNumber();
            for (TemperatureToHumidity temperatureToHumidity : listOfMaps.getTemperatureToHumidityList()) {
                seed.setSeedNumber(temperatureToHumidity.convertToDestination(seed.getSeedNumber()));
                if (tempNr != seed.getSeedNumber()) {
                    System.out.println("Seed number changed to : " + seed.getSeedNumber() + " från " +tempNr );
                    break;
                }
            }
        }

        for (Seed seed : listOfMaps.getSeedList()) {
            double tempNr = seed.getSeedNumber();
            for (HumidityToLocation humidityToLocation : listOfMaps.getHumidityToLocationList()) {
                seed.setSeedNumber(humidityToLocation.convertToDestination(seed.getSeedNumber()));
                if (tempNr != seed.getSeedNumber()) {
                    System.out.println("Seed number changed to : " + seed.getSeedNumber() + " från " +tempNr );
                    break;
                }
            }
        }

        for (Seed seed : listOfMaps.getSeedList()) {
            if (seed.getSeedNumber() < minValue) {
                minValue = seed.getSeedNumber();
            }
        }
        System.out.println("Closest seed " + minValue);
    }

}
