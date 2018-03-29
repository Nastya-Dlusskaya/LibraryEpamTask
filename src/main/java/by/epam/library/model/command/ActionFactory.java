package by.epam.library.model.command;

public class ActionFactory {

    /**
     * Find necessary command
     * @param typeCommand
     * @return
     */
    public ActionCommand defineCommand(String typeCommand) {
        if(typeCommand == null || typeCommand.equals("")){
            return new EmptyCommand();
        }
        CommandEnum currentEnum = CommandEnum.getCommandEnum(typeCommand);

        switch (currentEnum){
            case LOGIN:
                return new LoginCommand();
            default:
                return new EmptyCommand();
        }
    }
}
