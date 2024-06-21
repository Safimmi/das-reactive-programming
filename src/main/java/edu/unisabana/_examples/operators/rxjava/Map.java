package edu.unisabana._examples.operators.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class Map {
  public static void main(String[] args) {
    Observable.just(1, 2, 3, 4, 5)
        .map(item -> item * 2)
        .subscribe(System.out::println);
  }
}
