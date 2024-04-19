package com.example.demobnabd.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userdata")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping("/{userDataId}")
    public ResponseEntity<UserData> getUserDataById(@PathVariable Long userDataId) {
        Optional<UserData> userDataOptional = userDataService.findById(userDataId);
        return userDataOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserData>> getAllUserData() {
        List<UserData> userDataList = userDataService.findAll();
        return ResponseEntity.ok(userDataList);
    }

    @PostMapping
    public ResponseEntity<UserData> createUserData(@RequestBody UserData userData) {
        UserData createdUserData = userDataService.save(userData);
        return ResponseEntity.ok(createdUserData);
    }

    @PutMapping("/{userDataId}")
    public ResponseEntity<UserData> updateUserData(@PathVariable Long userDataId, @RequestBody UserData updatedUserData) {
        Optional<UserData> userDataOptional = userDataService.findById(userDataId);
        if (userDataOptional.isPresent()) {
            updatedUserData.setUserDataId(userDataId);
            UserData userData = userDataService.save(updatedUserData);
            return ResponseEntity.ok(userData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userDataId}")
    public ResponseEntity<Void> deleteUserData(@PathVariable Long userDataId) {
        userDataService.deleteById(userDataId);
        return ResponseEntity.noContent().build();
    }
}
