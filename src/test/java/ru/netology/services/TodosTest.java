package ru.netology.services;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    private Task[] tasks = new Task[0];

    // Вспомогательный метод для имитации добавления элемента в массив
    // @current - массив, в который мы хотим добавить элемент.
    // @task - элемент, который мы хотим добавить.
    // @return -Возвращает новый массив, в конце которого добавлен новый элемент.

    private Task[] addToArray(Task[] current, Task task) {
        Task[] tmp = new Task[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }


    //Метод добавления задачи в список дел
    public void add(Task task) { // <- вот здесь в параметре может лежать объект и вида SimpleTask, и вида Epic, и вида Meeting
        tasks = addToArray(tasks, task);
    }

    public Task[] findAll() {
        return tasks;
    }


    // Метод поиска задач, которые подходят под поисковый запрос
    public Task[] search(String query) {
        Task[] result = new Task[0]; // массив для ответа
        for (Task task : tasks) { // перебираем все задачи
            if (task.matches(query)) { // если задача подходит под запрос
                result = addToArray(result, task); // добавляем её в массив ответа
            }
        }
        return result;
    }

}