package com.maria.springproject.dto;

public class PreMunDto {

	private String preName;
	private Long preId;
	private String munName;
	private Long munParentId;

	public PreMunDto(String preName, Long preId, String munName, Long munParentId) {
		super();
		this.preName = preName;
		this.preId = preId;
		this.munName = munName;
		this.munParentId = munParentId;
	}

	public String getPreName() {
		return preName;
	}

	public void setPreName(String preName) {
		this.preName = preName;
	}

	public Long getPreId() {
		return preId;
	}

	public void setPreId(Long preId) {
		this.preId = preId;
	}

	public String getMunName() {
		return munName;
	}

	public void setMunName(String munName) {
		this.munName = munName;
	}

	public Long getMunParentId() {
		return munParentId;
	}

	public void setMunParentId(Long munParentId) {
		this.munParentId = munParentId;
	}

}
