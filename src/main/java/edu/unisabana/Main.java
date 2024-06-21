package edu.unisabana;

import java.util.List;

import edu.unisabana.controller.CountryController;
import edu.unisabana.model.Country;
import edu.unisabana.service.CountryService;
import io.reactivex.rxjava3.core.Observable;

public class Main {
  public static void main(String[] args) {
    System.err.println("---- Reactive Programming ----");
    CountryService countryService = new CountryService();
    CountryController controller = new CountryController(countryService);

    Observable<List<Country>> countriesFromOceania = controller.getCountriesFromOceania();
    countriesFromOceania.subscribe(
        countries -> countries.forEach(country -> System.out.println(country.toString())),
        error -> System.err.println("Error: " + error.getMessage()),
        () -> System.out.println(" [X] Async Operation Completed"));

    // * Do other actions
    System.out.println(" [Main] Doing other things on the main thread...");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
