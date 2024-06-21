package edu.unisabana.controller;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

import edu.unisabana.model.Country;
import edu.unisabana.service.CountryService;

public class CountryController {
  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  public Observable<List<Country>> getCountriesFromOceania() {
    System.err.println(" [Controller] Getting countries from Oceania...");
    return countryService.getCountriesByRegion("Oceania");
  }
}
