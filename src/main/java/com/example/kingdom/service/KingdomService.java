package com.example.kingdom.service;

import com.example.kingdom.entity.Warrior;
import com.example.kingdom.repository.WarriorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KingdomService {

    @Autowired
    private WarriorRepository warriorRepository;

    @Cacheable("getWarriors") // 武将の全件検索結果をキャッシュに登録する
    public List<Warrior> getAllWarriors() {
        List<Warrior> allWarriors = new ArrayList<>();
        warriorRepository.findAll().forEach(allWarriors::add);
        return allWarriors;
    }

    @Cacheable(value = "getWarrior", key = "#p0") // キー値ごとにキャッシュを作成する
    public Optional<Warrior> getWarrior(String name) {
        return warriorRepository.findWarriorByName(name);
    }

    @CacheEvict(value = "getWarriors", allEntries = true)
    public void addWarrior(Warrior warrior) {
        warriorRepository.save(warrior);
    }

    @Caching(evict = {
            @CacheEvict(value = "getWarrior", key = "#p0"),
            @CacheEvict(value = "getWarriors", allEntries = true)
    })
    public void updateWarrior(Warrior warrior, Long id) {
        if (warriorRepository.findById(id).isPresent()) {
//            warriorRepository.deleteById(warriorRepository.findWarriorByName(name).get().getId());
            warriorRepository.save(warrior);
        }
    }

    public void deleteWarrior(Long id) {
        warriorRepository.deleteById(id);
    }

    public void updateWarriorByName(Warrior warrior, String name) {
        Optional<Warrior> updatedWarriorOptional = warriorRepository.findWarriorByName(name);
        if (updatedWarriorOptional.isPresent()) {
            Warrior updatedWarrior = updatedWarriorOptional.get();
//            warrior.setId(updatedWarrior.get().getId());
            if (warrior.getName() != null) {
                updatedWarrior.setName(warrior.getName());
            }
            if (warrior.getPower() != null) {
                updatedWarrior.setPower(warrior.getPower());
            }
            if (warrior.getIntelligence() != null) {
                updatedWarrior.setIntelligence(warrior.getIntelligence());
            }
            if (warrior.getLeadership() != null) {
                updatedWarrior.setLeadership(warrior.getLeadership());
            }
            warriorRepository.save(updatedWarrior);
        }

//        warriorRepository.findWarriorByName(name).ifPresent((updatedWarrior) -> {
//
////            warrior.setId(updatedWarrior.get().getId());
//            if (warrior.getName() != null) {
//                updatedWarrior.setName(warrior.getName());
//            }
//            if (warrior.getPower() != null) {
//                updatedWarrior.setPower(warrior.getPower());
//            }
//            if (warrior.getIntelligence() != null) {
//                updatedWarrior.setIntelligence(warrior.getIntelligence());
//            }
//            if (warrior.getLeadership() != null) {
//                updatedWarrior.setLeadership(warrior.getLeadership());
//            }
//            warriorRepository.save(updatedWarrior);
//        });
    }
}
