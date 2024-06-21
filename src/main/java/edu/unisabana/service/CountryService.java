package edu.unisabana.service;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import edu.unisabana.model.Country;

public class CountryService {
  private static final String API_URL = "https://restcountries.com/v3.1/all";

  public Observable<List<Country>> getCountriesByRegion(String region) {
    System.err.println(" [Service] Requesting and filtering countries by region...");
    return Observable.fromCallable(() -> makeHttpRequest(API_URL))
        .subscribeOn(Schedulers.io())
        .map(response -> countryMapper(response.body()))
        .flatMapIterable(countries -> countries)
        .filter(country -> country.getRegion().equalsIgnoreCase(region))
        .toList()
        .toObservable();
  }

  private HttpResponse<String> makeHttpRequest(String url) {
    try {
      System.err.println("\t [Service] Doing HTTP API request...");
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(url))
          .header("Content-Type", "application/json")
          .GET()
          .build();

      return client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (Exception e) {
      System.err.println("Error making HTTP request: " + e.getMessage());
      return null;
    }
  }

  private static List<Country> countryMapper(String json) {
    List<Country> countries = new ArrayList<>();
    try {
      JSONArray countriesArray = new JSONArray(json);
      for (int i = 0; i < countriesArray.length(); i++) {
        JSONObject countryObject = countriesArray.getJSONObject(i);
        JSONObject nameObject = countryObject.getJSONObject("name");
        String commonName = nameObject.getString("common");
        String region = countryObject.getString("region").toString();
        countries.add(new Country(commonName, region));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return countries;
  }
}
