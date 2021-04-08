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
    public List<AdministrativeTerritorialUnit> saveATU(@RequestBody AdministrativeTerritorialUnit atu) throws ObjectAlreadyExistsException {
        atuService.saveATU(atu);
        return atuService.getAllATU();
    }


}
