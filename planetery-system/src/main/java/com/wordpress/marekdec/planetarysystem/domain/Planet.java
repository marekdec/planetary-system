package com.wordpress.marekdec.planetarysystem.domain;

public class Planet {

	private String name;
	private double kilometersOfRadius;
	private double yearDurationInEarthDays;
	private boolean hasRingSystem;
	private boolean hasAtmosphere;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getKilometersOfRadius() {
		return kilometersOfRadius;
	}

	public void setKilometersOfRadius(double kilometersOfRadius) {
		this.kilometersOfRadius = kilometersOfRadius;
	}

	public double getYearDurationInEarthDays() {
		return yearDurationInEarthDays;
	}

	public void setYearDurationInEarthDays(double yearDurationInEarthDays) {
		this.yearDurationInEarthDays = yearDurationInEarthDays;
	}

	public boolean hasRingSystem() {
		return hasRingSystem;
	}

	public void setHasRingSystem(boolean hasRingSystem) {
		this.hasRingSystem = hasRingSystem;
	}

	public boolean hasAtmosphere() {
		return hasAtmosphere;
	}

	public void setHasAtmosphere(boolean hasAtmosphere) {
		this.hasAtmosphere = hasAtmosphere;
	}

}
