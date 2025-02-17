package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    Todos todos = new Todos();

    SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
    SimpleTask simpleTask2 = new SimpleTask(7, "Написать письмо");
    SimpleTask simpleTask3 = new SimpleTask(8, "Оплатить счет из банка");

    String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
    Epic products = new Epic(55, subtasks1);

    String[] subtasks2 = {"Русский язык", "Литература", "Физика", "География"};
    Epic lessons = new Epic(59, subtasks2);

    String[] subtasks3 = {"Полицейская академия 3", "Крепкий орешек", "Такси"};
    Epic films = new Epic(53, subtasks3);

    Meeting meeting1 = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Meeting meeting2 = new Meeting(
            716,
            "Java-dz-project",
            "Добавить дз к лекции 13",
            "До четверга"
    );

    Meeting meeting3 = new Meeting(
            833,
            "Подготовка к собеседованию по вакансии",
            "написать сопроводительное письмо",
            "До вечера пятницы"
    );

    //@BeforeEach
    public void setup() {
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(products);
        todos.add(lessons);
        todos.add(films);
        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);
    }

    // Пустой массив
    @Test
    public void shouldEmptyArray() {
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, todos.findAll());
    }

    // Проверка добавления трех видов задач
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        setup();
        Task[] expected = {simpleTask1, simpleTask2, simpleTask3, products, lessons, films, meeting1, meeting2, meeting3};
        Assertions.assertArrayEquals(expected, todos.findAll());
    }

    // Проверка поиска по простой задаче
    @Test
    public void shouldFindWordInSimpleTask() {
        setup();

        Task[] expected = {simpleTask2};
        Assertions.assertArrayEquals(expected, todos.search("Написать"));
    }

    // Проверка поиска по задачам с массивом из подзадач
    @Test
    public void shouldFindWordInEpic() {
        setup();

        Task[] expected = {lessons};
        Assertions.assertArrayEquals(expected, todos.search("Литература"));
    }

    // Проверка поиска по титулам задач, описывающих встречи
    @Test
    public void shouldFindWordInMeetingTitle() {
        setup();

        Task[] expected = {meeting1};
        Assertions.assertArrayEquals(expected, todos.search("Выкатка"));
    }

    // Проверка поиска по названиям проектов задач, описывающих встречи
    @Test
    public void shouldFindWordInMeetingProject() {
        setup();

        Task[] expected = {meeting2};
        Assertions.assertArrayEquals(expected, todos.search("дз"));
    }

    // Проверка поиска по части слова
    @Test
    public void shouldMultipleMatches() {
        setup();

        Task[] expected = {simpleTask3, lessons, films, meeting1, meeting3};
        Assertions.assertArrayEquals(expected, todos.search("ка"));
    }

    // Проверка поиска на чувствительность к регистру букв
    @Test
    public void CaseSensitivity() {
        setup();

        Task[] expected = {meeting1};
        Assertions.assertArrayEquals(expected, todos.search("Банка"));
    }

    // Проверка отсутствия при поиске по задачам
    @Test
    public void shouldNotSearchTask() {
        setup();

        Task[] expected = {};
        Assertions.assertArrayEquals(expected, todos.search("яблоко"));
    }

    //Одно совпадение по задачам
    @Test
    public void shouldOneSearchTask() {
        setup();

        Task[] expected = {simpleTask3};
        Assertions.assertArrayEquals(expected, todos.search("счет"));
    }

    // Проверка поиска при вводе на английском
    @Test
    public void shouldSearchEnglish() {
        setup();

        Task[] expected = {meeting2};
        Assertions.assertArrayEquals(expected, todos.search("project"));
    }

    // Два совпадения по задачам
    @Test
    public void shouldTwoSearchTask() {
        setup();

        Task[] expected = {simpleTask2, meeting3};
        Task[] actual = todos.search("письмо");
        Assertions.assertArrayEquals(expected, actual);
    }
}