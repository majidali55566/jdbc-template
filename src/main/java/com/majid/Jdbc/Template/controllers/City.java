package com.majid.Jdbc.Template.controllers;

public class City {
	
	private long id;
	private String name;
	private long population;
	private String district;
	public City() {
		
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", population=" + population + ", district=" + district + "]";
	}
	public City(String name,long population, String district) {
		this.name = name;
		this.population = population;
		this.district = district;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
}
