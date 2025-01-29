package ru.netology.services;

// Простая задача.
public class SimpleTask extends Task {

    private String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    //  Переопределение matches
    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        }
        return false;
    }

}