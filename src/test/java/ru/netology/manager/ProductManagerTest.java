package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product first = new Book(1, "Мастер и Маргарита", 240, "Михаил Булгаков");
    private Product second = new Book(2, "Мертвые души", 770, "Николай Гоголь");
    private Product third = new Book(3, "Собачье сердце", 740, "Михаил Булгаков");
    private Product fourth = new Book(4, "Будет кровь", 830, "Стивен Кинг");
    private Product fifth = new Book(5, "Анна Каренина", 670, "Лев Толстой");
    private Product sixth = new Book(6, "Евгений Онегин", 490, "Александр Пушкин");
    private Product seventh = new Smartphone(7, "Realme 6 Pro", 22000, "Realme");
    private Product eighth = new Smartphone(8, "vivo V20", 30000, "Vivo");
    private Product ninth = new Smartphone(9, "Xiaomi Mi 10T Lite", 27000, "Xiaomi");
    private Product tenth = new Smartphone(10, "Samsung Galaxy M22", 19000, "Samsung");
    private Product eleventh = new Smartphone(11, "Samsung Galaxy A51", 17000, "Samsung");
    private Product twelfth = new Product(12, "Laptop", 50000);


    @BeforeEach
    public void shouldSaveAllProduct() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

    }

    @Test
    public void shouldSearchByName() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Мертвые души");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName2() {
        Product[] expected = new Product[]{eleventh};
        Product[] actual = manager.searchBy("Samsung Galaxy A51");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName3() {
        Product[] expected = new Product[]{tenth};
        Product[] actual = manager.searchBy("Samsung Galaxy M22");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Лев Толстой");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName4() {
        Product[] expected = new Product[]{eighth};
        Product[] actual = manager.searchBy("vivo V20");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        Product[] expected = new Product[]{ninth};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProduct() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Laptop");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameIfItIsNotTheOnlyOne() {
        Product[] expected = new Product[]{tenth, eleventh};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

}