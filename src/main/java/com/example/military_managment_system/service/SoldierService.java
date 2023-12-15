package com.example.military_managment_system.service;


import com.example.military_managment_system.model.Soldier;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SoldierService {
    public Soldier saveSoldier(Soldier soldier);
    public Soldier updateSoldier(Soldier soldier);
    public Soldier findSoldier(Long id);
    public Optional<Soldier>  findOneSoldier(Long id);
    public List<Soldier> getAllSoldier();
    public void deleteSoldier(Long id);
    Page<Soldier> pagenateStudent(int pageNo, int pageSize,String sortField,String sortDirection);
}
