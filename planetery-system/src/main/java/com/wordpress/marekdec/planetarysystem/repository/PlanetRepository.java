package com.wordpress.marekdec.planetarysystem.repository;

import java.util.List;

import com.wordpress.marekdec.planetarysystem.domain.Planet;

public interface PlanetRepository {

	Planet getByName(String string);

	List<Planet> getAllPlanets();

}
