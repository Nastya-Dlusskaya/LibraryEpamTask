package by.epam.library.model.command;

public enum CommandEnum {
    LOGIN("login");

    String value;

    CommandEnum(String value) {
        this.value = value;
    }

    public static CommandEnum getCommandEnum(String value){
        CommandEnum[] commands = CommandEnum.values();
        for (CommandEnum command:commands) {
            String commandValue = command.value;
            if (value.equals(commandValue)){
                return command;
            }
        }
        return null;
    }
}
