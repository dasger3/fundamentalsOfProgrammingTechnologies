package views;

import models.pojo.*;

import java.util.List;
import java.util.Map;

public interface View {
    void ShowATU (AdministrativeTerritorialUnit administrativeTerritorialUnit);
    void ShowRegion(Region region);
    void ShowCity (City city);
    void ShowVillage (Village village);
    void ShowDistrict (District district);

    void ShowCityPopulationSum(int result);
    void ShowAveragePopulationOfVillage(double result);
    void ShowCityMaxPopulation(int result);
    void ShowVillageWithFilter(Map<Boolean, List<Village>> result);
    void ShowMostFrequentCityTitleNames(List<String> result);
}
