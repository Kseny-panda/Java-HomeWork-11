package ru.netology.services;

// Задача, описывающая назначенную встречу.
public class Meeting extends Task {

    private String topic;                // Тема обсуждения
    private String project;              // Название проекта
    private String start;                // Дата и время начала текстом

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    //  Переопределение matches
    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}