package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.P_medias;

@Repository
public interface P_mediasRepository extends JpaRepository<P_medias, Integer>{

}
