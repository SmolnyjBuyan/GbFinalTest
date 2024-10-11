package org.example.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public enum AbstractAnimalType {
    PET(1, "Pet", "pets", "pet_commands", "pet_id"),
    PACK_ANIMAL(2, "Pack Animal", "pack_animals", "pack_animal_commands", "pack_animal_id");
    private final String title;
    private final int id;
    private final String tableName;
    private final String commandTableName;
    private final String commandTableColumnName;
    private static final Map<Integer, AbstractAnimalType> ID_FOR_ABSTRACT_ANIMAL_TYPE = new LinkedHashMap<>();

    static {
        ID_FOR_ABSTRACT_ANIMAL_TYPE.put(1, PET);
        ID_FOR_ABSTRACT_ANIMAL_TYPE.put(2, PACK_ANIMAL);
    }

    AbstractAnimalType(int id, String title, String tableName, String commandTableName, String commandTableColumnName) {
        this.id = id;
        this.title = title;
        this.tableName = tableName;
        this.commandTableName = commandTableName;
        this.commandTableColumnName = commandTableColumnName;
    }

    public int getId() {
        return id;
    }
    public String getTableName() {
        return tableName;
    }

    public String getCommandTableName() {
        return  commandTableName;
    }

    public String getCommandTableColumnName() {
        return commandTableColumnName;
    }

    public static AbstractAnimalType get(int id) {
        return ID_FOR_ABSTRACT_ANIMAL_TYPE.get(id);
    }

    public static Map<Integer, AbstractAnimalType> getAnimalTypes(){
        return ID_FOR_ABSTRACT_ANIMAL_TYPE;
    }

    @Override
    public String toString() {
        return title;
    }
}
