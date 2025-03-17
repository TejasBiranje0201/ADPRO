package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.E_media;

@Repository
public interface E_mediaRepository extends JpaRepository<E_media, Integer> {

}
