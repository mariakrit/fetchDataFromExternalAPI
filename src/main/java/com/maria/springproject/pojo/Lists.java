package com.maria.springproject.pojo;

import java.util.List;

public class Lists {

	private List<Prefecture> prefectures;
	private List<Municipality> municipalities;

	public Lists() {
		super();
	}

	public List<Prefecture> getPrefectures() {
		return prefectures;
	}

	public void setPrefectures(List<Prefecture> prefectures) {
		this.prefectures = prefectures;
	}

	public List<Municipality> getMunicipalities() {
		return municipalities;
	}

	public void setMunicipalities(List<Municipality> municipalities) {
		this.municipalities = municipalities;
	}

}
