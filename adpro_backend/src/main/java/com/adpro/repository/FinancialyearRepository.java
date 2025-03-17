package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Financialyear;

@Repository
public interface FinancialyearRepository extends JpaRepository<Financialyear, Integer> {

}
