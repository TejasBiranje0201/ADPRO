package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Gst;

@Repository
public interface GstRepository extends JpaRepository<Gst, Integer> {

}
