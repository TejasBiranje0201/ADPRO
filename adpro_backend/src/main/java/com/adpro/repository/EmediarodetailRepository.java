package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Emediarodetail;

@Repository
public interface EmediarodetailRepository extends JpaRepository<Emediarodetail, Integer> {

}
