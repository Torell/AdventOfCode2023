package Day5;

public class SeedNumberCalculator2 {

    private double minValue;

    public SeedNumberCalculator2(ListOfMaps listOfMaps) {
        this.minValue = Integer.MAX_VALUE;
        System.out.println("seed to soil");
        outerloop:
        for (Seed seed : listOfMaps.getSeedList()) {
            Double seedNumber = seed.getSeedNumber();
            Double tempNr = seed.getSeedNumber();
            for (int i = 0; i < seed.getSeedRange() ; i++) {
                for (SeedToSoil seedToSoil : listOfMaps.getSeedToSoilList()) {
                    tempNr = seedToSoil.convertToDestination(seedNumber);
                    if (tempNr != seedNumber) {
                        break;
                    }
                    for (SoilToFertilizer soilToFertilizer : listOfMaps.getSoilToFertilizerList()) {
                        double OGtemp = tempNr;
                        tempNr = soilToFertilizer.convertToDestination(tempNr);
                        if (OGtemp != tempNr) {
                            break;
                        }
                        for (FertilizerToWater fertilizerToWater : listOfMaps.getFertilizerToWaterList()) {
                            double fertTemp = OGtemp;
                            OGtemp = fertilizerToWater.convertToDestination(OGtemp);
                            if (OGtemp != fertTemp) {
                                break;
                            }
                            for (WaterToLight waterToLight : listOfMaps.getWaterToLightList()) {
                                double waterTemp = OGtemp;
                                OGtemp = waterToLight.convertToDestination(OGtemp);
                                if (OGtemp != waterTemp) {
                                    break;
                                }


                                for (LightToTemperature lightToTemperature = listOfMaps.getLightToTemperatureList()) {
                                    double lightTemp = OGtemp;
                                    OGtemp = lightToTemperature.convertToDestination(OGtemp);
                                    if (OGtemp != lightTemp) {
                                        break;
                                    }
                                }
                                    for (TemperatureToHumidity temperatureToHumidity : listOfMaps.getTemperatureToHumidityList()) {
                                        double tempTemp = OGtemp;
                                        OGtemp = temperatureToHumidity.convertToDestination(OGtemp);
                                        if (OGtemp != tempTemp) {
                                            break;
                                        }
                                    }
                                        for (HumidityToLocation humidityToLocation : listOfMaps.getHumidityToLocationList()) {
                                            double humidTemp = OGtemp;
                                            OGtemp = humidityToLocation.convertToDestination(OGtemp);
                                            if (OGtemp != humidTemp) {
                                                minValue = OGtemp;
                                                continue outerloop;
                                            }
                                            }

                                        }
                                    }
                                }

                            }
                        }

                    }
                }





