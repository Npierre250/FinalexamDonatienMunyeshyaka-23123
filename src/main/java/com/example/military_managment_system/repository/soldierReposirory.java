package com.example.military_managment_system.repository;

import com.example.military_managment_system.model.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface soldierReposirory extends JpaRepository<Soldier,Long> {
   Optional<Soldier> findSoldierByIdIs(Long id);
}
