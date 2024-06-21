package edu.unisabana._examples;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

class Order {
  private final String product;
  private final int quantity;
  private final double price;

  public Order(String product, int quantity, double price) {
    this.product = product;
    this.quantity = quantity;
    this.price = price;
  }

  public String getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }
}

public class OrdersManager {
  public static void main(String[] args) {
    List<Order> orders = Arrays.asList(
        new Order("Product A", 2, 50.0),
        new Order("Product B", 1, 30.0),
        new Order("Product A", 1, 50.0),
        new Order("Product C", 3, 20.0));

    Observable.fromIterable(orders)
        .filter(order -> "Product A".equals(order.getProduct())) // Filtrar por Producto A
        .map(order -> order.getQuantity() * order.getPrice()) // Calcular el total por pedido
        .reduce(Double::sum) // Calcular el total de ventas para Producto A
        .subscribe(total -> System.out.println("Total sales for Product A: " + total));
  }
}