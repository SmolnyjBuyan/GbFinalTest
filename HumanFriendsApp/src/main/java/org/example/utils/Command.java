package org.example.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Command {
    SIT(1, "Sit"), STAY(2, "Stay"), FETCH(3, "Fetch"), POUNCE(4, "Pounce"),
    ROLL(5, "Roll"), HIDE(6, "Hide"), PAW(7, "Paw"), BARK(8, "Bark"),
    SCRATCH(9, "Scratch"), SPIN(10, "Spin"), MEOW(11, "Meow"), JUMP(12, "Jump"),
    TROT(13, "Trot"), CANTER(14, "Canter"), GALLOP(15, "Gallop"), WALK(16, "Walk"),
    CARRY_LOAD(17, "Carry Load"), BRAY(18, "Bray"), KICK(19, "Kick"), RUN(20, "Run");

    private final int id;
    private final String title;
    private static final Map<Integer, Command> ID_FOR_COMMAND = new LinkedHashMap<>();

    static {
        ID_FOR_COMMAND.put(1, SIT);
        ID_FOR_COMMAND.put(2, STAY);
        ID_FOR_COMMAND.put(3, FETCH);
        ID_FOR_COMMAND.put(4, POUNCE);
        ID_FOR_COMMAND.put(5, ROLL);
        ID_FOR_COMMAND.put(6, HIDE);
        ID_FOR_COMMAND.put(7, PAW);
        ID_FOR_COMMAND.put(8, BARK);
        ID_FOR_COMMAND.put(9, SCRATCH);
        ID_FOR_COMMAND.put(10, SPIN);
        ID_FOR_COMMAND.put(11, MEOW);
        ID_FOR_COMMAND.put(12, JUMP);
        ID_FOR_COMMAND.put(13, TROT);
        ID_FOR_COMMAND.put(14, CANTER);
        ID_FOR_COMMAND.put(15, GALLOP);
        ID_FOR_COMMAND.put(16, WALK);
        ID_FOR_COMMAND.put(17, CARRY_LOAD);
        ID_FOR_COMMAND.put(18, BRAY);
        ID_FOR_COMMAND.put(19, KICK);
        ID_FOR_COMMAND.put(20, RUN);
    }

    Command (int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId(){
        return id;
    }

    public static Command get(int id) {
        return ID_FOR_COMMAND.get(id);
    }

    public static Map<Integer, Command> getCommands() {
        return ID_FOR_COMMAND;
    }

    @Override
    public String toString() {
        return title;
    }
}
