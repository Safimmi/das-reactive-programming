package edu.unisabana._examples.operators.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class Filter {
  public static void main(String[] args) {
    Observable.just(1, 2, 3, 4, 5)
        .filter(item -> item % 2 == 0)
        .subscribe(System.out::println);
  }
}