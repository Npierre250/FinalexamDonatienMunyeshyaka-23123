package com.example.military_managment_system.service;

import com.example.military_managment_system.model.Soldier;
import com.example.military_managment_system.repository.soldierReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class soldierServiceImp implements SoldierService {
    @Autowired
    private soldierReposirory reposirory;

    @Override
    public Soldier saveSoldier(Soldier soldier) {
        return reposirory.save(soldier);
    }

    @Override
    public Soldier updateSoldier(Soldier soldier) {
        return reposirory.save(soldier);
    }

    @Override
    public Soldier findSoldier(Long id) {
        return reposirory.findById(id).get();
    }

    @Override
    @Transactional
    public Optional <Soldier> findOneSoldier(Long id) {
        return reposirory.findById(id);
    }

    @Override
    public List<Soldier> getAllSoldier() {
        return reposirory.findAll() ;
    }


    @Override
    public void deleteSoldier(Long id) {
        reposirory.deleteById(id);
    }

    @Override
    public Page<Soldier> pagenateStudent(int pageNo, int pageSize,String sortField,String sortDirection) {
        Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).ascending();
        Pageable pageable= PageRequest.of(pageNo -1,pageSize,sort);
        return this.reposirory.findAll(pageable);
    }
}
