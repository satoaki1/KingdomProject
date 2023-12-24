package com.example.kingdom.repository;

import com.example.kingdom.entity.Warrior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarriorRepository extends JpaRepository<Warrior, Long> {
    Optional<Warrior> findWarriorByName(String name);
}
