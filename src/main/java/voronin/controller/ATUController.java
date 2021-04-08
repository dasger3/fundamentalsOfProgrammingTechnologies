package voronin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import voronin.exception.ObjectAlreadyExistsException;
import voronin.model.AdministrativeTerritorialUnit;
import voronin.service.ATUService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("ATU")
public class ATUController {

    private final ATUService atuService;

    @GetMapping("/")
    public List<AdministrativeTerritorialUnit> findAllATU () {
        return atuService.getAllATU();
    }

    @GetMapping("/{id}")
    public AdministrativeTerritorialUnit findATUById (@PathVariable Long id) {
        return atuService.getATUById(id);
    }

    @GetMapping("/name/{title}")
    public AdministrativeTerritorialUnit findATUByTitle (@PathVariable String title) {
        return atuService.getATUByTitle(title);
    }

    @GetMapping("/type/{type}")
    public List<AdministrativeTerritorialUnit> findAllATUByType (@PathVariable String type) {
        return atuService.getAllATUByType(type);
    }

    @PostMapping
    public List<AdministrativeTerritorialUnit> saveATU(@RequestBody AdministrativeTerritorialUnit atu) {
        atuService.saveATU(atu);
        return atuService.getAllATU();
    }

    @DeleteMapping("/{id}")
    public List<AdministrativeTerritorialUnit> deleteATU(@PathVariable Long id) {
        atuService.deleteATU(id);
        return atuService.getAllATU();
    }

    @PutMapping("/{id}")
    public List<AdministrativeTerritorialUnit> updateATU(@PathVariable Long id, @RequestBody AdministrativeTerritorialUnit atu) {
        atuService.updateATU(id, atu);
        return atuService.getAllATU();
    }

    @PatchMapping("/addParentId/")
    @ResponseBody
    public List<AdministrativeTerritorialUnit> addParentATU(@RequestParam Long id, @RequestParam Long idParent) {
        atuService.addParentATU(id,idParent);
        return atuService.getAllATU();
    }

    @PatchMapping("/addCenterId/")
    @ResponseBody
    public List<AdministrativeTerritorialUnit> addCenterATU(@RequestParam Long id, @RequestParam Long idCenter) {
        atuService.addCenterATU(id,idCenter);
        return atuService.getAllATU();
    }

    @PatchMapping("/addManager/")
    @ResponseBody
    public List<AdministrativeTerritorialUnit> addManagerToATU(@RequestParam Long id, @RequestParam Long idManager) {
        atuService.addManagerToATU(id,idManager);
        return atuService.getAllATU();
    }
}
