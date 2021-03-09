package models.services;

import models.pojo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StatisticsServiceImpl implements StatisticsService {
    public int getCityPopulationSum(List<City> list) {
        return list.stream().
                filter(x -> x.getSquare()>100).
                mapToInt(City::getPopulation).
                sum();
    }

    public double getAveragePopulation(List<Village> list) {
        return list.stream().
                mapToInt(Village::getPopulation).
                average().getAsDouble();
    }

    public int getMaxPopulation(List<City> list) {
        return list.stream().
                mapToInt(City::getPopulation).
                max().getAsInt();
    }

    public Map<Boolean, List<Village>> getVillageWithFilter(List<Village> list, Predicate<Village> condition) {

        return list.stream().collect(Collectors.partitioningBy(condition));

    }

    public List<String> getMostFrequentTitleNames(List<Region> regionList) {
        List<String> result = new ArrayList<>();
        regionList.stream()
                .flatMap(x -> x.getCity().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(City::getPosition))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(City::getTitle, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }
}
