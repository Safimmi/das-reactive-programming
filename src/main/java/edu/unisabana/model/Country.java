package edu.unisabana.model;

public class Country {
  private String name;
  private String region;

  public Country(String name, String region) {
    this.name = name;
    this.region = region;
  }

  public String getName() {
    return name;
  }

  public String getRegion() {
    return region;
  }

  @Override
  public String toString() {
    return "Country {" + "name='" + name + "', region='" + region + "'}";
  }
}
