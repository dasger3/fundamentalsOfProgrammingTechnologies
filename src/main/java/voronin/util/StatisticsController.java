//package Voronin.controllers;
//
//import Voronin.services.StatisticsServiceImpl;
//import Voronin.model.Region;
//import Voronin.views.ConsoleView;
//import Voronin.views.View;
//
//import java.util.ArrayList;
//
//public class StatisticsController {
//
//    private StatisticsServiceImpl statisticsService;
//    private View view = new ConsoleView();
//    public StatisticsController (StatisticsServiceImpl statisticsService) {
//        this.statisticsService = statisticsService;
//    }
//
//    public void getStatisticsOfRegion (ArrayList<Region> listOfRegion) {
//        view.ShowCityPopulationSum(statisticsService.getCityPopulationSum(listOfRegion.get(0).getCity()));
//        view.ShowAveragePopulationOfVillage(statisticsService.getAveragePopulation(listOfRegion.get(0).getVillage()));
//        view.ShowCityMaxPopulation(statisticsService.getMaxPopulation(listOfRegion.get(0).getCity()));
//        view.ShowVillageWithFilter(statisticsService.getVillageWithFilter(listOfRegion.get(0).getVillage(),p -> p.getOccupation().equals("harvest") && p.getPopulation()>40));
//        view.ShowMostFrequentCityTitleNames(statisticsService.getMostFrequentTitleNames(listOfRegion));
//    }
//}
