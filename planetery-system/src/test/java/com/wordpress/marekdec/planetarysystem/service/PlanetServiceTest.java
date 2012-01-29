package com.wordpress.marekdec.planetarysystem.service;

import static com.googlecode.mockarro.Mockarro.given;
import static com.googlecode.mockarro.Mockarro.instanceForTesting;
import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.googlecode.mockarro.TypeLiteral;
import com.wordpress.marekdec.planetarysystem.domain.Planet;

public class PlanetServiceTest {

	private PlanetService planetService;

	@Before
	public void init() {
		planetService = instanceForTesting(PlanetService.class);
	}

	@Test
	public void retrievePlanetWithRadiusMostSimilarToEarthsTest() {
		// given
		Planet earth = planet("earth", 6371);
		given(Planet.class).isRequested().thenReturn(earth);

		given(new TypeLiteral<List<Planet>>() {}).isRequested().thenReturn(
				asList(earth, planet("Mars", 3396), planet("Tatooine", 55000),
						planet("Arrakis", 10123), planet("Solaris", 12700)));

		// when
		Planet planet = planetService
				.retrievePlanetWithRadiusMostSimilarToEarths();

		// then
		assertThat(planet).isNotNull().isNotSameAs(earth);
		assertThat(planet.getName()).isEqualTo("Mars");
	}

	@Test(expected = IllegalStateException.class)
	public void retrievePlanetWithRadiusMostSimilarToEarthsTest_when_no_earth_defined() {
		// given
		given(Planet.class).isRequested().thenReturn(null);

		// when
		planetService.retrievePlanetWithRadiusMostSimilarToEarths();

		// then expect an exception
	}

	private Planet planet(String name, long radius) {
		Planet planet = new Planet();
		planet.setName(name);
		planet.setKilometersOfRadius(radius);

		return planet;
	}
}
