package Day5;

public class SeedNumberCalculator2v2 {

    private double minValue;
    private double Temp;
    private double seedTemp;
    private double soilTemp;
    private double fertTemp;
    private double waterTemp;
    private double lightTemp;
    private double tempTemp;

    private double humidTemp;
    private double locationTemp;

    public SeedNumberCalculator2v2(ListOfMaps listOfMaps) {
        this.minValue = Integer.MAX_VALUE;
        System.out.println("seed to soil");
        outerloop:
        for (Seed seed : listOfMaps.getSeedList()) {

            for (int i = 0; i < seed.getSeedRange(); i++) {
                seedTemp = seed.getSeedNumber() + i;
                for (SoilToFertilizer soilToFertilizer : listOfMaps.getSoilToFertilizerList()) {
                    fertTemp = seedTemp;
                    fertTemp = soilToFertilizer.convertToDestination(fertTemp);
                    if (fertTemp != seedTemp) {
                        break;
                    }
                }
                for (FertilizerToWater fertilizerToWater : listOfMaps.getFertilizerToWaterList()) {
                    waterTemp = fertTemp;
                    waterTemp = fertilizerToWater.convertToDestination(waterTemp);
                    if (waterTemp != fertTemp) {
                        break;
                    }
                }
                for (WaterToLight waterToLight : listOfMaps.getWaterToLightList()) {
                    lightTemp = waterTemp;
                    lightTemp = waterToLight.convertToDestination(lightTemp);
                    if (lightTemp != waterTemp) {
                        break;
                    }
                }
                for (LightToTemperature lightToTemperature : listOfMaps.getLightToTemperatureList()) {
                    tempTemp = lightTemp;
                    tempTemp = lightToTemperature.convertToDestination(tempTemp);
                    if (tempTemp != lightTemp) {
                        break;
                    }
                }
                for (TemperatureToHumidity temperatureToHumidity : listOfMaps.getTemperatureToHumidityList()) {
                    humidTemp = tempTemp;
                    humidTemp = temperatureToHumidity.convertToDestination(humidTemp);
                    if (humidTemp != tempTemp) {
                        break;
                    }
                }
                for (HumidityToLocation humidityToLocation : listOfMaps.getHumidityToLocationList()) {
                    locationTemp = humidTemp;
                    locationTemp = humidityToLocation.convertToDestination(locationTemp);
                    if (lightTemp != humidTemp) {
                        minValue = locationTemp;
                        break;
                    }
                    minValue = locationTemp;

                }
            }
        }
    }
}





