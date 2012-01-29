package com.wordpress.marekdec.planetarysystem.service;

import javax.inject.Inject;

import com.wordpress.marekdec.planetarysystem.domain.Planet;
import com.wordpress.marekdec.planetarysystem.repository.PlanetRepository;

public class PlanetService {

	@Inject
	private PlanetRepository planetRepository;

	@Inject
	private SolarSystemService solarSystemService;

	public Planet retrievePlanetWithRadiusMostSimilarToEarths() {
		Planet earth = solarSystemService.getEarth();

		if (earth != null) {
			double earthRadius = earth.getKilometersOfRadius();

			Planet mostSimilarPlanet = null;
			double smallestDiff = Double.POSITIVE_INFINITY;
			for (Planet planet : planetRepository.getAllPlanets()) {
				if (planet != earth) {

					double diff = Math.abs(planet.getKilometersOfRadius()
							- earthRadius);
					if (diff < smallestDiff) {
						smallestDiff = diff;
						mostSimilarPlanet = planet;
					}
				}
			}
			return mostSimilarPlanet;
		} else {
			throw new IllegalStateException(
					"No earth in in the planet's repository");
		}
	}
}
