package ru.netology.manager;

public class MovieManager {
    private String[] movies = new String[0];
    private int limit;

    // Конструктор по умолчанию — лимит 5 последних фильмов
    public MovieManager() {
        this.limit = 5;
    }

    // Конструктор с параметром — лимит задаётся извне
    public MovieManager(int limit) {
        this.limit = limit;
    }

    // Добавление нового фильма (массив расширяется на 1)
    public void add(String movie) {
        String[] tmp = new String[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    // Все фильмы в порядке добавления
    public String[] findAll() {
        return movies.clone();
    }

    // Последние N фильмов в порядке добавления (N = limit)
    public String[] findLast() {
        // Вычисляем длину результата: либо limit, либо весь массив (если он короче)
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            // Берём элементы с конца исходного массива и кладём в result в обратном порядке добавления,
            // но при этом result должен быть в порядке добавления.
            result[i] = movies[movies.length - resultLength + i];
        }
        return result;
    }
}
