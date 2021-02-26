package controllers;

import models.pojo.Region;
import models.pojo.Village;
import models.services.DBLayer;
import models.services.ModelLayer;
import models.services.StatisticsService;
import views.ConsoleView;
import views.View;

import java.util.ArrayList;

public class Controller {

    ModelLayer modelLayer = new DBLayer();
    StatisticsService statisticsService = new StatisticsService();

    View view = new ConsoleView();

    public void createRegion (Region region) {
        modelLayer.addRegion(region);
    }
    public void getRegion (String title) {
        view.ConsoleShowRegion(modelLayer.getRegion("Example"));
    }
    public void getStatistics (ArrayList<Region> listOfRegion) {
        view.ConsoleShowCityPopulationSum(statisticsService.getCityPopulationSum(listOfRegion.get(0).getCity()));
        view.ConsoleAveragePopulaitonOfVillage(statisticsService.getAveragePopulaiton(listOfRegion.get(0).getVillage()));
        view.ConsoleShowCityMaxPopulation(statisticsService.getMaxPopulation(listOfRegion.get(0).getCity()));
        view.ConsoleShowVillageWithFilter(statisticsService.getVillageWithFilter(listOfRegion.get(0).getVillage(),p -> p.getOccupation().equals("harvest") && p.getPopulation()>40));
        view.ConsoleShowMostFrequentCityTitleNames(statisticsService.getMostFrequentTitleNames(listOfRegion));
    }


}
