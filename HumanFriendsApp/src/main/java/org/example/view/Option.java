package org.example.view;

public class Option {
    private String title;
    private Executable function;

    public Option(String title, Executable function) {
        this.title = title;
        this.function = function;
    }

    public void execute() {
        function.execute();
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
