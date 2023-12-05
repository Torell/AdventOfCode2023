package Day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOfMaps {

    private List<Seed> seedList;
    private List<FertilizerToWater> fertilizerToWaterList;
    private List<HumidityToLocation> humidityToLocationList;

    private List<LightToTemperature> lightToTemperatureList;
    private List<SeedToSoil> seedToSoilList;
    private List<SoilToFertilizer> soilToFertilizerList;
    private List<TemperatureToHumidity> temperatureToHumidityList;
    private List<WaterToLight> waterToLightList;

    private List<Map> mapList;

    public ListOfMaps() {
        this.seedList = new ArrayList<>();
        this.fertilizerToWaterList = new ArrayList<>();
        this.humidityToLocationList = new ArrayList<>();

        this.lightToTemperatureList = new ArrayList<>();
        this.seedToSoilList = new ArrayList<>();
        this.soilToFertilizerList = new ArrayList<>();
        this.temperatureToHumidityList = new ArrayList<>();
        this.waterToLightList = new ArrayList<>();
    }

    public void sort() {
        this.seedList.sort(new Comparator<Seed>() {
            @Override
            public int compare(Seed o1, Seed o2) {
                return Double.compare(o1.getSeedNumber(), o2.getSeedNumber());
            }
        });
        Collections.reverse(this.seedList);

        this.fertilizerToWaterList.sort(new Comparator<FertilizerToWater>() {
            @Override
            public int compare(FertilizerToWater o1, FertilizerToWater o2) {
                return Double.compare(o1.getSourceRange()+ o1.getSourceRange(), o2.getSourceRange()+ o2.getSourceRange()); // Replace getProperty() with the actual getter method
            }
        });
        Collections.reverse(this.fertilizerToWaterList);

        this.humidityToLocationList.sort(new Comparator<HumidityToLocation>() {
            @Override
            public int compare(HumidityToLocation o1, HumidityToLocation o2) {
                return Double.compare(o1.getSourceRange()+ o1.getSourceRange(), o2.getSourceRange()+ o2.getSourceRange()); // Replace getProperty() with the actual getter method
            }
        });

        Collections.reverse(this.humidityToLocationList);
        this.lightToTemperatureList.sort(new Comparator<LightToTemperature>() {
            @Override
            public int compare(LightToTemperature o1, LightToTemperature o2) {
                return Double.compare(o1.getSourceRange()+ o1.getSourceRange(), o2.getSourceRange()+ o2.getSourceRange());
            }
        });

        Collections.reverse(this.lightToTemperatureList);

        this.seedToSoilList.sort(new Comparator<SeedToSoil>() {
            @Override
            public int compare(SeedToSoil o1, SeedToSoil o2) {
                return Double.compare(o1.getSourceRange()+ o1.getSourceRange(), o2.getSourceRange()+ o2.getSourceRange());
            }
        });

        Collections.reverse(this.seedToSoilList);

        this.waterToLightList.sort(new Comparator<WaterToLight>() {
            @Override
            public int compare(WaterToLight o1, WaterToLight o2) {
                return Double.compare(o1.getSourceRange()+ o1.getSourceRange(), o2.getSourceRange()+ o2.getSourceRange()); // Replace getProperty() with the actual getter method
            }
        });


        Collections.reverse(this.waterToLightList);

        this.soilToFertilizerList.sort(new Comparator<SoilToFertilizer>() {
            @Override
            public int compare(SoilToFertilizer o1, SoilToFertilizer o2) {
                return Double.compare(o1.getSourceRange()+ o1.getSourceRange(), o2.getSourceRange()+ o2.getSourceRange());
            }
        });

        Collections.reverse(soilToFertilizerList);

        this.temperatureToHumidityList.sort(new Comparator<TemperatureToHumidity>() {
            @Override
            public int compare(TemperatureToHumidity o1, TemperatureToHumidity o2) {
                return Double.compare(o1.getSourceRange()+ o1.getSourceRange(), o2.getSourceRange()+ o2.getSourceRange());
            }
        });

        Collections.reverse(this.temperatureToHumidityList);
    }

    public List<Seed> getSeedList() {
        return seedList;
    }

    public void addToSeedList(Seed input) {
        this.seedList.add(input);
    }

    public List<FertilizerToWater> getFertilizerToWaterList() {
        return fertilizerToWaterList;
    }

    public void addToFertilizerWaterList(FertilizerToWater input) {
        this.fertilizerToWaterList.add(input);
    }

    public List<HumidityToLocation> getHumidityToLocationList() {
        return humidityToLocationList;
    }

    public void addToHumidityLocationList(HumidityToLocation input) {
        this.humidityToLocationList.add(input);
    }

    public List<LightToTemperature> getLightToTemperatureList() {
        return lightToTemperatureList;
    }

    public void addToLightTemperatureList(LightToTemperature input) {
        this.lightToTemperatureList.add(input);
    }

    public List<SeedToSoil> getSeedToSoilList() {
        return seedToSoilList;
    }

    public void addToSeedSoilList(SeedToSoil input) {
        this.seedToSoilList.add(input);
    }

    public List<SoilToFertilizer> getSoilToFertilizerList() {
        return soilToFertilizerList;
    }

    public void addToSoilFertilizerList(SoilToFertilizer input) {
        this.soilToFertilizerList.add(input);
    }

    public List<TemperatureToHumidity> getTemperatureToHumidityList() {
        return temperatureToHumidityList;
    }

    public void addToTemperatureHumidityList(TemperatureToHumidity input) {
        this.temperatureToHumidityList.add(input);
    }

    public List<WaterToLight> getWaterToLightList() {
        return waterToLightList;
    }

    public void addToWaterLightList(WaterToLight input) {
        this.waterToLightList.add(input);
    }
}
