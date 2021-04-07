package voronin.controller;

import lombok.RequiredArgsConstructor;
import voronin.model.AdministrativeTerritorialUnit;
import voronin.service.ATUService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("ATU")
public class ATUController {

    private final ATUService atuService;

    @GetMapping("/")
    public List<AdministrativeTerritorialUnit> allATU () {
        return atuService.getATUs();
    }

    @GetMapping("/{id}")
    public AdministrativeTerritorialUnit findATUById (@PathVariable Long id) {
        return atuService.getATUById(id);
    }
//
//
    @GetMapping("/name/{title}")
    public AdministrativeTerritorialUnit findATUByTitle (@PathVariable String title) {
        return atuService.getATUByTitle(title);
    }

    @GetMapping("/type/{type}")
    public List<AdministrativeTerritorialUnit> findAllATUByType (@PathVariable String type) {
        return atuService.getAllATUByType(type);
    }
////    @GetMapping("/list1/{id}")
////    public List<AdministrativeTerritorialUnit> findInternalList1ById (@PathVariable Long id) {
////        return atuService.getInternalList1ById(id);
////    }
////    @GetMapping("/list2/{id}")
////    public List<AdministrativeTerritorialUnit> findInternalList2ById (@PathVariable Long id) {
////        return atuService.getInternalList2ById(id);
////    }
//


}
