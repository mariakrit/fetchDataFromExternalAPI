package com.maria.springproject.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maria.springproject.dto.PreMunDto;
import com.maria.springproject.entity.MunicipalityEntity;
import com.maria.springproject.entity.PrefectureEntity;

@Repository
public interface MunicipalitiesRepository extends JpaRepository<MunicipalityEntity, Long> {

	@Query(nativeQuery = true, name = "find_matched_values")
	List<PreMunDto> fetchEmpDeptDataInnerJoin();

}
