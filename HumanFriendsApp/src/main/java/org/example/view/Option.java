package org.example.view;

public class Option {
    private final String title;
    private final Executable function;

    public Option(String title, Executable function) {
        this.title = title;
        this.function = function;
    }

    public void execute() {
        function.execute();
    }

    @Override
    public String toString() {
        return title;
    }
}
