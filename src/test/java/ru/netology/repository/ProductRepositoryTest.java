package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Name 1", 100, "Autor 1", 150, 2011);
    private Book second = new Book(2, "Name 2", 100, "Autor 2", 200, 2012);
    private Book third = new Book(3, "Name 3", 300, "Autor 3", 300, 2013);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(2);

        Product[] expected = new Product[]{first, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotFound() {

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });

    }


}
