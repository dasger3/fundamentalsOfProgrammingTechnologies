package voronin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voronin.model.User;
import voronin.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("User")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<List<User>> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return findAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return findAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return findAllUsers();
    }
    @PatchMapping("/addRoleId")
    public ResponseEntity<List<User>> addRoleId(@RequestParam Long id, @RequestParam Long idRole) {
        userService.addRoleId(id, idRole);
        return findAllUsers();
    }
}