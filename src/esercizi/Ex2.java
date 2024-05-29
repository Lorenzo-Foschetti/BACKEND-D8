package esercizi;

import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ex2 {
    public static void main(String[] args) {
        Product product1 = new Product(1333, "Harry Potter", "Book", 103);
        Product product2 = new Product(5466, "Il signore degli anelli", "Film", 31);
        Product product3 = new Product(7665, "Hannybal", "Book", 40);
        Product product4 = new Product(13362, "Harry Potter", "Book", 103);
        Product product5 = new Product(52716, "Topolino", "Baby", 31);
        Product product6 = new Product(7663325, "Hannybal", "Book", 40);
        Product product7 = new Product(13332, "Harry Potter", "Book", 103);
        Product product8 = new Product(5625, "Il signore degli anelli", "Film", 31);
        Product product9 = new Product(88726, "Paperino", "Baby", 40);

        Product[] arrayProducts1 = {product1, product2, product3};
        Product[] arrayProducts2 = {product4, product5, product6};
        Product[] arrayProducts3 = {product7, product8, product9};

        List<Product> listOfProducts1 = Arrays.stream(arrayProducts1).toList();
        List<Product> listOfProducts2 = Arrays.stream(arrayProducts2).toList();
        List<Product> listOfProducts3 = Arrays.stream(arrayProducts3).toList();

        Customer customer1 = new Customer(635262L, "Giulia", 2);
        Customer customer2 = new Customer(66636L, "Giuseppe", 1);
        Customer customer3 = new Customer(55142L, "Valerio", 5);

        Order order1 = new Order(55625L, "in consegna", LocalDate.now(), LocalDate.now().plusDays(10), listOfProducts1, customer1);
        Order order2 = new Order(55625L, "in consegna", LocalDate.now(), LocalDate.now().plusDays(10), listOfProducts2, customer1);

        List<Order> babyOrders = new ArrayList<>();
        babyOrders.add(order1);
        babyOrders.add(order2);


        babyOrders = babyOrders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> Objects.equals(product.getCategory(), "Baby"))).toList();


        System.out.println(babyOrders);

    }
}
