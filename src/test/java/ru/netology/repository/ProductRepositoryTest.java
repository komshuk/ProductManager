package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();
    private final Book firstBook = new Book(1, "Alice’s Adventures in Wonderland", 228, "Lewis Carroll");
    private final Book secondBook = new Book(2, "Through the Looking-Glass, and What Alice Found There", 307, "Lewis Carroll");
    private final Smartphone firstSmartphone = new Smartphone(3, "8.3", 49_990, "Nokia");
    private final Smartphone secondSmartphone = new Smartphone(4, "5.3 4/64", 15_990, "Nokia");


    @BeforeEach
    public void setUp() {
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(firstSmartphone);
        repository.save(secondSmartphone);
    }

    @Test
    public void mustDeleteAnExistingElement() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone};
        Product[] actual = repository.removeById(4);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAnExceptionWhenTryingToDeleteNonExistentElement() {
        int id = 5;

        assertThrows(NotFoundException.class, () -> repository.removeById(5));
        assertThrows(NotFoundException.class, () -> repository.removeById(5), "Element with id: " + id + " not found");
    }
}
