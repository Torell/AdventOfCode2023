package Day5;

import java.sql.SQLOutput;

public class SeedNumberCalculator2v2 {

    private double minValue;
    private double tempDouble;
    private double seedTemp;
    private double soilTemp;
    private double fertTemp;
    private double waterTemp;
    private double lightTemp;
    private double tempTemp;

    private double humidTemp;
    private double locationTemp;

    public SeedNumberCalculator2v2(ListOfMaps listOfMaps) {

        for (Seed seeds : listOfMaps.getSeedList()) {
            System.out.println(seeds.getSeedNumber());
        }


        this.minValue = Integer.MAX_VALUE;
        System.out.println( "first value: " + listOfMaps.getSeedList().get(0).getSeedNumber());

        outerloop:
        for (Seed seed : listOfMaps.getSeedList()) {
            //  for (int i = 0; i < seed.getSeedRange(); i++) {
            soilTemp = seed.getSeedNumber();
            tempDouble = seed.getSeedNumber();
            System.out.println("seednumber: " + seed.getSeedNumber());

            for (SeedToSoil seedToSoil : listOfMaps.getSeedToSoilList()) {
                seedTemp = tempDouble;
                tempDouble = seedToSoil.convertToDestination(tempDouble);
                if (seedTemp != tempDouble) {
                   // System.out.println("old value : " + seedTemp + " new value " + tempDouble);
                    break;
                }
            }
            for (SoilToFertilizer soilToFertilizer : listOfMaps.getSoilToFertilizerList()) {
                fertTemp = tempDouble;
                tempDouble = soilToFertilizer.convertToDestination(tempDouble);
                if (fertTemp != tempDouble) {
                   // System.out.println("old value : " + fertTemp + " new value " + tempDouble);
                    break;
                }
            }
            for (FertilizerToWater fertilizerToWater : listOfMaps.getFertilizerToWaterList()) {
                waterTemp = tempDouble;
                tempDouble = fertilizerToWater.convertToDestination(tempDouble);
                if (waterTemp != tempDouble) {
                   // System.out.println("old value : " + waterTemp + " new value " + tempDouble);
                    break;
                }
            }
            for (WaterToLight waterToLight : listOfMaps.getWaterToLightList()) {
                lightTemp = tempDouble;
                tempDouble = waterToLight.convertToDestination(tempDouble);
                if (lightTemp != tempDouble) {
                   // System.out.println("old value : " + lightTemp + " new value " + tempDouble);
                    break;
                }
            }
            for (LightToTemperature lightToTemperature : listOfMaps.getLightToTemperatureList()) {
                tempTemp = tempDouble;
                tempDouble = lightToTemperature.convertToDestination(tempDouble);
                if (tempTemp != tempDouble) {
                    //System.out.println("old value : " + tempTemp+ " new value " + tempDouble);
                    break;
                }
            }
            for (TemperatureToHumidity temperatureToHumidity : listOfMaps.getTemperatureToHumidityList()) {
                humidTemp = tempDouble;
                tempDouble = temperatureToHumidity.convertToDestination(tempDouble);
                if (humidTemp != tempDouble) {
                    //System.out.println("old value : " + humidTemp + " new value " + tempDouble);
                    break;
                }
            }
            for (HumidityToLocation humidityToLocation : listOfMaps.getHumidityToLocationList()) {
                locationTemp = tempDouble;
                tempDouble = humidityToLocation.convertToDestination(tempDouble);
                if (minValue > tempDouble) {
                    minValue = locationTemp;
                }
                if (locationTemp != tempDouble) {
                    //System.out.println("seednr " + seedTemp + " locationNr: " + locationTemp);
                    System.out.println("old value : " + seed.getSeedNumber() + " new value " + tempDouble);
                    continue outerloop;
                }
            }
            //System.out.println("seednr " + seedTemp + " locationNr: " + locationTemp + " And it didnt break the loop");
        }


        System.out.println("closest location: " + minValue);


    }


}






