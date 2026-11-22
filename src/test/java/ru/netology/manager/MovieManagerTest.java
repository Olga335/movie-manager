package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    void shouldBeEmptyOnCreate() {
        MovieManager manager = new MovieManager();
        Assertions.assertArrayEquals(new String[0], manager.findAll());
        Assertions.assertArrayEquals(new String[0], manager.findLast());
    }

    @Test
    void shouldReturnAllMoviesInOrder() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        String[] expected = {"Film 1", "Film 2", "Film 3"};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldReturnAllMoviesIfLessThanLimit() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        String[] expected = {"Film 1", "Film 2", "Film 3"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnLastMoviesIfLimitReached() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        String[] expected = {"Film 1", "Film 2", "Film 3", "Film 4", "Film 5"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnLastMoviesIfMoreThanLimit() {
        MovieManager manager = new MovieManager();
        for (int i = 1; i <= 10; i++) {
            manager.add("Film " + i);
        }
        String[] expected = {"Film 6", "Film 7", "Film 8", "Film 9", "Film 10"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldUseCustomLimit() {
        MovieManager manager = new MovieManager(3);
        for (int i = 1; i <= 10; i++) {
            manager.add("Film " + i);
        }
        String[] expected = {"Film 8", "Film 9", "Film 10"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
}
