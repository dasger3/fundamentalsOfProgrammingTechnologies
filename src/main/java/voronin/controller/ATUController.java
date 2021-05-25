package voronin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AdministrativeTerritorialUnit>> findAllATU () {
        return ResponseEntity.ok(atuService.getAllATU());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministrativeTerritorialUnit> findATUById (@PathVariable Long id) {
        return ResponseEntity.ok(atuService.getATUById(id));
    }

    @GetMapping("/name/{title}")
    public ResponseEntity<AdministrativeTerritorialUnit> findATUByTitle (@PathVariable String title) {
        return ResponseEntity.ok(atuService.getATUByTitle(title));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<AdministrativeTerritorialUnit>> findAllATUByType (@PathVariable String type) {
        return ResponseEntity.ok(atuService.getAllATUByType(type));
    }

    @PostMapping
    public ResponseEntity<List<AdministrativeTerritorialUnit>> saveATU(@RequestBody AdministrativeTerritorialUnit atu) {
        atuService.saveATU(atu);
        return ResponseEntity.ok(atuService.getAllATU());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<AdministrativeTerritorialUnit>> deleteATU(@PathVariable Long id) {
        atuService.deleteATU(id);
        return ResponseEntity.ok(atuService.getAllATU());
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<AdministrativeTerritorialUnit>> updateATU(@PathVariable Long id, @RequestBody AdministrativeTerritorialUnit atu) {
        atuService.updateATU(id, atu);
        return ResponseEntity.ok(atuService.getAllATU());
    }

    @PatchMapping("/addParentId/")
    @ResponseBody
    public ResponseEntity<List<AdministrativeTerritorialUnit>> addParentATU(@RequestParam Long id, @RequestParam Long idParent) {
        atuService.addParentATU(id,idParent);
        return ResponseEntity.ok(atuService.getAllATU());
    }

    @PatchMapping("/addCenterId/")
    @ResponseBody
    public ResponseEntity<List<AdministrativeTerritorialUnit>> addCenterATU(@RequestParam Long id, @RequestParam Long idCenter) {
        atuService.addCenterATU(id,idCenter);
        return ResponseEntity.ok(atuService.getAllATU());
    }

    @PatchMapping("/addManager/")
    @ResponseBody
    public ResponseEntity<List<AdministrativeTerritorialUnit>> addManagerToATU(@RequestParam Long id, @RequestParam Long idManager) {
        atuService.addManagerToATU(id,idManager);
        return ResponseEntity.ok(atuService.getAllATU());
    }
}
