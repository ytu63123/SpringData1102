package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.Inventory2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository2 extends JpaRepository<Inventory2, Integer>{
    
}