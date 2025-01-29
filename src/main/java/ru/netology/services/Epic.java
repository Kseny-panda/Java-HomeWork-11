package ru.netology.services;

public class Epic extends Task {

    private String[] subtasks;

    public Epic(int id, String[] subtask) {
        super(id);
        this.subtasks = subtask;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    // Переопределение matches
    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
