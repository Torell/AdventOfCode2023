package Day5;

import java.io.IOException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws IOException {



        double minValue = Integer.MAX_VALUE;

        ReadDataAndCreateObjects data = new ReadDataAndCreateObjects();



        ListOfMaps listOfMaps = data.getListOfMaps();
        listOfMaps.sort();


        OuterLoop:
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



        /*
        for(SeedToSoil seedToSoil : listOfMaps.getSeedToSoilList()) {
           // System.out.println("Seed to soil");
            System.out.println(seedToSoil.getSourceRange());
            for (Seed seed : listOfMaps.getSeedList()) {
             //   System.out.println("seed");
            //    System.out.println(seed.getSeedNumber());
                seed.setSeedNumber(seedToSoil.convertToDestination(seed.getSeedNumber()));
            //    System.out.println(seed.getSeedNumber());
            }
        }


        System.out.println("soil to fertilizer");
        for (SoilToFertilizer soilToFertilizer : listOfMaps.getSoilToFertilizerList()) {
          //  System.out.println("soil to fertiliz");
            for (Seed seed : listOfMaps.getSeedList()) {
            //    System.out.println("seed");
            //    System.out.println(seed.getSeedNumber());
                seed.setSeedNumber(soilToFertilizer.convertToDestination(seed.getSeedNumber()));
           //     System.out.println(seed.getSeedNumber());
            }
        }

        System.out.println("fert to water");
        for (FertilizerToWater fertilizerToWater : listOfMaps.getFertilizerToWaterList()) {
          //  System.out.println("fert to water");
            for (Seed seed : listOfMaps.getSeedList()) {
           //     System.out.println("seed");
           //     System.out.println(seed.getSeedNumber());
                seed.setSeedNumber(fertilizerToWater.convertToDestination(seed.getSeedNumber()));
           //     System.out.println(seed.getSeedNumber());
            }
        }


        for (WaterToLight waterToLight : listOfMaps.getWaterToLightList()) {

         //   System.out.println("Water to light");
            for (Seed seed : listOfMaps.getSeedList()) {
            //    System.out.println("seed");
            //    System.out.println(seed.getSeedNumber());
                seed.setSeedNumber(waterToLight.convertToDestination(seed.getSeedNumber()));
             //   System.out.println(seed.getSeedNumber());
            }
        }

        for (LightToTemperature lightToTemperature : listOfMaps.getLightToTemperatureList()) {
           // System.out.println("Light to temp");
            for (Seed seed : listOfMaps.getSeedList()) {
             //   System.out.println("seed");
            //    System.out.println(seed.getSeedNumber());
                seed.setSeedNumber(lightToTemperature.convertToDestination(seed.getSeedNumber()));
            //    System.out.println(seed.getSeedNumber());
            }
        }

        for (TemperatureToHumidity temperatureToHumidity : listOfMaps.getTemperatureToHumidityList()) {
          //  System.out.println("Temp to Humid");
            for (Seed seed : listOfMaps.getSeedList()) {
          //      System.out.println("seed");
          //      System.out.println(seed.getSeedNumber());
                seed.setSeedNumber(temperatureToHumidity.convertToDestination(seed.getSeedNumber()));
            //    System.out.println(seed.getSeedNumber());
            }
        }

        for (HumidityToLocation humidityToLocation : listOfMaps.getHumidityToLocationList()) {
          //  System.out.println("Humid to locat");
            for (Seed seed : listOfMaps.getSeedList()) {
            //    System.out.println("seed");
            //    System.out.println(seed.getSeedNumber());
                seed.setSeedNumber(humidityToLocation.convertToDestination(seed.getSeedNumber()));
            //    System.out.println(seed.getSeedNumber());
            }
        }

        for (Seed seed : listOfMaps.getSeedList()) {
            if (seed.getSeedNumber() < minValue) {
                minValue = seed.getSeedNumber();
            }
        }


         */



        System.out.println("Closest seed " + minValue);
    }
}
