package ru.netology.manager;

import ru.netology.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);
    private final Book firstBook = new Book(1, "Alice’s Adventures in Wonderland", 228, "Lewis Carroll");
    private final Book secondBook = new Book(2, "Through the Looking-Glass, and What Alice Found There", 307, "Lewis Carroll");
    private final Smartphone firstSmartphone = new Smartphone(3, "8.3", 49_990, "Nokia");
    private final Smartphone secondSmartphone = new Smartphone(4, "5.3 4/64", 15_990, "Nokia");


    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);

    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneManufacturer() {
        Product[] expected = new Product[]{firstSmartphone, secondSmartphone};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("5.3 4/64");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookAuthor() {
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = manager.searchBy("Lewis Carroll");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBookTitle() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Alice’s Adventures in Wonderland");
        assertArrayEquals(expected, actual);
    }

}
