package com.example.kingdom.controller;

import com.example.kingdom.entity.Warrior;
import com.example.kingdom.exception.WarriorNotFoundException;
import com.example.kingdom.service.KingdomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KingdomController {

    @Autowired
    private KingdomService kingdomService;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/warriors")
    public List<Warrior> getAllWarriors() {
        return kingdomService.getAllWarriors();
    }

    @GetMapping("/warriors/{name}")
    public Warrior getWarrior(@PathVariable("name") String name) {
        return kingdomService.getWarrior(name).orElseThrow(() -> new WarriorNotFoundException(name));
    }

    @PostMapping("/warriors")
    public void addWarrior(@RequestBody Warrior warrior) {
        kingdomService.addWarrior(warrior);
    }

    @PutMapping("/warriors/{id}")
    public void updateWarrior(@RequestBody Warrior warrior, @PathVariable("id") Long id) {
        kingdomService.updateWarrior(warrior, id);
    }

    @PutMapping("/warriors/n/{name}")
    public void updateWarriorByName(@RequestBody Warrior warrior, @PathVariable("name") String name) {
        kingdomService.updateWarriorByName(warrior, name);
    }

    @DeleteMapping("/warriors/{id}")
    public void deleteWarrior(@PathVariable("id") Long id) {
        kingdomService.deleteWarrior(id);
    }
}
