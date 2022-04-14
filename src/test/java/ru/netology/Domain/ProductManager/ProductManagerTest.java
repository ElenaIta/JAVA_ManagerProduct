package ru.netology.Domain.ProductManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;
import ru.netology.Domain.repository.ProductRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager();

    Product first = new Book(1, "Angels and Demons", 2000, "Dan Brown");
    Product second = new Book(2, "Faust", 1500, "Goethe");
    Product third = new Smartphone(3, "3210", 11000, "Nokia");
    Product fourth = new Smartphone(4, "Gold", 23000, "Samsung");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] expected = {second};
        Product[] actual = manager.searchBy("Faust");

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNoName() {

        Product[] actual = manager.searchBy("WOW");
        Product[] expected = new Product[0];

        System.out.println(Arrays.toString(actual));
        
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByNameAuthor() {
        Product[] expected = {first};
        Product[] actual = manager.searchBy("Dan Brown");

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }
}