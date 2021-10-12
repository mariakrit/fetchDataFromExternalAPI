package com.maria.springproject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Prefectures")
public class PrefectureEntity  implements Serializable{


	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "parentid")
	private int parentId;

	@Column(name = "countryid")
	private int countryId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@OneToMany(targetEntity = MunicipalityEntity.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<MunicipalityEntity> municipalities;

	public Set<MunicipalityEntity> getMunicipalities() {
		return municipalities;
	}

	public void setMunicipalities(Set<MunicipalityEntity> municipalities) {
		this.municipalities = municipalities;
	}

}
