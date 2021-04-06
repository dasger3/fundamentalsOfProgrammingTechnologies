package voronin.service;

import voronin.model.City;
import voronin.model.Village;
import voronin.model.Region;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface StatisticsService {

    int getCityPopulationSum(List<City> list);
    double getAveragePopulation(List<Village> list);
    int getMaxPopulation(List<City> list);
    Map<Boolean, List<Village>> getVillageWithFilter(List<Village> list, Predicate<Village> condition);
    List<String> getMostFrequentTitleNames(List<Region> regionList);
}
