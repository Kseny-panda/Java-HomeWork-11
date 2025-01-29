package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    // Вывод Id задачи
    @Test
    public void shouldTaskGetId() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        int expected = 5;

        Assertions.assertEquals(expected, simpleTask1.getId());
        //System.out.println(simpleTask1.getId());
    }

    // Вывод титула простой задачи
    @Test
    public void shouldSimpleTaskGeTitle() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        String expected = "Позвонить родителям";

        Assertions.assertEquals(expected, simpleTask1.getTitle());
        //System.out.println(simpleTask1.getTitle());
    }

    // Вывод задачи с массивом подзадач
    @Test
    public void shouldEpicGetSubtasks() {
        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic products = new Epic(55, subtasks1);

        String[] expected = subtasks1;
        Assertions.assertArrayEquals(expected, products.getSubtasks());
        //System.out.println(Arrays.toString(products.getSubtasks()));
    }

    // Вывод темы обсуждения у задачи, описывающий назначенную встречу
    @Test
    public void shouldMeetingGetTopic() {
        Meeting meeting2 = new Meeting(
                716,
                "Java-dz-project",
                "Добавить дз к лекции 13",
                "До четверга"
        );

        String expected = "Java-dz-project";
        Assertions.assertEquals(expected, meeting2.getTopic());
        //System.out.println(meeting2.getTopic());
    }

    // Вывод название проекта у задачи, описывающий назначенную встречу
    @Test
    public void shouldMeetingGetProject() {
        Meeting meeting2 = new Meeting(
                716,
                "Java-dz-project",
                "Добавить дз к лекции 13",
                "До четверга"
        );

        String expected = "Добавить дз к лекции 13";
        Assertions.assertEquals(expected, meeting2.getProject());
        //System.out.println(meeting2.getProject());
    }

    // Вывод времени старта у задачи, описывающий назначенную встречу
    @Test
    public void shouldMeetingGetStart() {
        Meeting meeting2 = new Meeting(
                716,
                "Java-dz-project",
                "Добавить дз к лекции 13",
                "До четверга"
        );

        String expected = "До четверга";
        Assertions.assertEquals(expected, meeting2.getStart());
        //System.out.println(meeting2.getStart());
    }

    // Проверка на отсутствие поиска у Task
    @Test
    public void shouldNotMatchesInTask() {
        Task task = new Task(80) {
        };

        boolean expected = false;
        Assertions.assertEquals(expected, task.matches("8"));
    }

    // Проверка на отсутствие совпадения у простой задачи
    @Test
    public void shouldNotMatchesInSimpleTask() {
        SimpleTask simpleTask3 = new SimpleTask(8, "Оплатить счет из банка");

        boolean expected = false;
        Assertions.assertEquals(expected, simpleTask3.matches("8"));
    }

    // Проверка на совпадение у простой задачи
    @Test
    public void shouldMatchesInSimpleTask() {
        SimpleTask simpleTask3 = new SimpleTask(8, "Оплатить счет из банка");

        boolean expected = true;
        Assertions.assertEquals(expected, simpleTask3.matches("счет"));
    }

    // Проверка на отсутствие совпадения в простой задаче при вводе в верхнем регистре
    @Test
    public void shouldNotMatchesInSimpleTaskUpperCase() {
        SimpleTask simpleTask3 = new SimpleTask(8, "Оплатить счет из банка");

        boolean expected = false;
        Assertions.assertEquals(expected, simpleTask3.matches("СЧЕТ"));
    }

    // Проверка на отсутствие совпадений при вводе с опечаткой у простой задачи
    @Test
    public void WithTypoInSimpleTask() {
        SimpleTask simpleTask3 = new SimpleTask(8, "Оплатить счет из банка");

        boolean expected = false;
        Assertions.assertEquals(expected, simpleTask3.matches("бнка"));
    }

    // Проверка на отсутствие совпадения у задачи с массивом подзадач
    @Test
    public void shouldNotMatchesInEpic() {
        String[] subtasks3 = {"Полицейская академия 3", "Крепкий орешек", "Такси"};
        Epic films = new Epic(53, subtasks3);

        boolean expected = false;
        Assertions.assertEquals(expected, films.matches("Пуаро"));
    }

    // Проверка совпадения у задачи с массивом подзадач
    @Test
    public void shouldMatchesInEpic() {
        String[] subtasks3 = {"Полицейская академия 3", "Крепкий орешек", "Такси"};
        Epic films = new Epic(53, subtasks3);

        boolean expected = true;
        Assertions.assertEquals(expected, films.matches("орешек"));
    }

    // Проверка на отсутствие совпадения у задачи с массивом подзадач при вводе в верхнем регистре
    @Test
    public void shouldNotMatchesInEpicUpperCase() {
        String[] subtasks3 = {"Полицейская академия 3", "Крепкий орешек", "Такси"};
        Epic films = new Epic(53, subtasks3);

        boolean expected = false;
        Assertions.assertEquals(expected, films.matches("ТАКСИ"));
    }

    // Проверка на отсутствие совпадений при вводе с опечаткой у задачи с массивом подзадач
    @Test
    public void WithTypoInEpic() {
        String[] subtasks3 = {"Полицейская академия 3", "Крепкий орешек", "Такси"};
        Epic films = new Epic(53, subtasks3);

        boolean expected = false;
        Assertions.assertEquals(expected, films.matches("Кепкий"));
    }

    // Проверка на отсутствие совпадений у задачи, описывающей назначенную встречу
    @Test
    public void shouldNotMatchesInMeeting() {
        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        Assertions.assertEquals(expected, meeting1.matches("ужина"));
    }

    // Проверка на совпадение у задачи, описывающей назначенную встречу
    @Test
    public void shouldMatchesInMeeting() {
        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        Assertions.assertEquals(expected, meeting1.matches("версии"));
    }

    // Проверка на отсутствие совпадений у задачи, описывающей назначенную встречу при вводе в верхнем регистре
    @Test
    public void shouldNotMatchesInMeetingUpperCase() {
        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        Assertions.assertEquals(expected, meeting1.matches("НЕТОБАНКА"));
    }

    // Проверка на отсутствие совпадений при вводе с опечаткой у задачи, описывающей назначенную встречу
    @Test
    public void WithTypoInMeeting() {
        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        Assertions.assertEquals(expected, meeting1.matches("Преложение"));
    }
}