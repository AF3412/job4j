package ru.af3412.tracker.di;

import ru.af3412.tracker.*;

public class StartUIByDI {

    private final ConsoleInput consoleInput;
    private final ITracker tracker = new Tracker();

    public StartUIByDI(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public static void main(String[] args) {

        Context context = new Context();
        context.reg(ConsoleInput.class);
        ConsoleInput ci = context.get(ConsoleInput.class);
        new StartUIByDI(ci).init();

    }

    public void init() {

        MenuTracker menu = new MenuTracker(this.consoleInput, tracker);
        menu.fillAction();
        int[] range = menu.getRange();

        do {
            menu.show();
            menu.select(consoleInput.ask("Select: ", range));
        } while (!"y".equals(this.consoleInput.ask("Exit? (y): ")));

    }

}
