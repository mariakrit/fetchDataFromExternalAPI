package com.maria.springproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.maria.springproject.dto.PreMunDto;


@Entity
@NamedNativeQuery
				  (name = "find_matched_values", 
				  query = "SELECT p.name as preName,"
						  + " p.id as preId, m.name as munName, "
						  + "m.parentid as munParentId FROM Prefectures p "
						  + "inner  JOIN Municipalities m on p.id = m.parentid", 
						  resultSetMapping = "com.maria.springproject.dto.PreMunDto")


@SqlResultSetMapping
				   (name = "com.maria.springproject.dto.PreMunDto", 
				   classes = @ConstructorResult(targetClass = PreMunDto.class, 
				   columns = {
							 @ColumnResult(name = "preName", type = String.class), 
							 @ColumnResult(name = "preId", type = Long.class),
							 @ColumnResult(name = "munName", type = String.class), 
							 @ColumnResult(name = "munParentId", type = Long.class) 
							 }))

@Table(name = "Municipalities")
public class MunicipalityEntity implements Serializable {

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private PrefectureEntity prefectures;

	public PrefectureEntity getPrefectures() {
		return prefectures;
	}

	public void setPrefectures(PrefectureEntity prefectures) {
		this.prefectures = prefectures;
	}

}
