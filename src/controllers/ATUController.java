package controllers;

import models.pojo.AdministrativeTerritorialUnit;
import models.pojo.Region;
import models.services.ATUService;
import views.ConsoleView;
import views.View;

public class ATUController {

    ATUService atuService;

    View view = new ConsoleView();

    public ATUController (ATUService atuService) {
        this.atuService = atuService;
    }

    public AdministrativeTerritorialUnit findATUByTitle (String title) {
        return atuService.getATUByTitle(title);
    }




}
