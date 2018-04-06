package by.epam.library.model.entity;

public enum TypePerson {
    ADMIN("admin"), READER("reader"), LIBRARIAN("librarian"), UNKNOWN("unknown");
    String value;

    TypePerson(String value) {
        this.value = value;
    }

    public static TypePerson getCommandEnum(String value){
        TypePerson[] persons = TypePerson.values();
        for (TypePerson person:persons) {
            String commandValue = person.value;
            if (value.equals(commandValue)){
                return person;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return value;
    }
}
