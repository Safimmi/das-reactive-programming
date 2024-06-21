package edu.unisabana._examples.operators.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class Zip {
  public static void main(String[] args) {
    Observable<Integer> observable1 = Observable.just(1, 2, 3);
    Observable<String> observable2 = Observable.just("A", "B", "C");

    Observable.zip(observable1, observable2, (num, letter) -> num + letter)
        .subscribe(System.out::println);
  }
}
