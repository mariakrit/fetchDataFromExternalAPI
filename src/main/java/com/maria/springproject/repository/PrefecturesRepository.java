package com.maria.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maria.springproject.entity.PrefectureEntity;

@Repository
public interface PrefecturesRepository extends JpaRepository<PrefectureEntity, Long> {

}
