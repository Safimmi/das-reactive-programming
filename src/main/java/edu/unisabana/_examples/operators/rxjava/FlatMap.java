package edu.unisabana._examples.operators.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class FlatMap {
  public static void main(String[] args) {
    Observable.just(1, 2, 3)
        .flatMap(item -> Observable.just(item * 10, item * 20))
        .subscribe(System.out::println);
  }
}