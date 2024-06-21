package edu.unisabana._examples.operators.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class Merge {
  public static void main(String[] args) {
    Observable<Integer> observable1 = Observable.just(1, 3, 5);
    Observable<Integer> observable2 = Observable.just(2, 4, 6);

    Observable.merge(observable1, observable2)
        .subscribe(System.out::println);
  }
}