package views;

import models.pojo.*;

import java.util.List;
import java.util.Map;

public interface View {
    void ConsoleShowATU (AdministrativeTerritorialUnit administrativeTerritorialUnit);
    void ConsoleShowRegion(Region region);
    void ConsoleShowCity (City city);
    void ConsoleShowVillage (Village village);
    void ConsoleShowDistrict (District district);

    void ConsoleShowCityPopulationSum(int result);
    void ConsoleAveragePopulaitonOfVillage(double result);
    void ConsoleShowCityMaxPopulation(int result);
    void ConsoleShowVillageWithFilter(Map<Boolean, List<Village>> result);
    void ConsoleShowMostFrequentCityTitleNames(List<String> result);
}
