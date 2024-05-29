package esercizi;

import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ex1 {
    public static void main(String[] args) {
        Product product1 = new Product(1333, "Harry Potter", "Book", 103);
        Product product2 = new Product(5466, "Il signore degli anelli", "Film", 31);
        Product product3 = new Product(7665, "Hannybal", "Book", 40);

        Product[] arrayProducts = {product1, product2, product3};
        List<Product> products = Arrays.stream(arrayProducts).toList();
        Customer customer1 = new Customer(6127L, "Marco", 3);

        Order order1 = new Order(55625L, "in consegna", LocalDate.now(), LocalDate.now().plusDays(10), products, customer1);

        List<Product> books = order1.getProducts().stream().filter(product -> Objects.equals(product.getCategory(), "Book") && product.getPrice() > 100).toList();
        System.out.println(books.toString());
    }
}
