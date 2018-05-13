package by.epam.library.model.command.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ActionFactory {
    private static ActionFactory instance = new ActionFactory( );
    private final Map<CommandEnum, ActionCommand> factory;

    private ActionFactory() {
        factory = new HashMap<>( );
        Properties properties = new Properties( );
        try {
            FileInputStream reader = new FileInputStream("D:\\EPAM_training\\mavenproject1\\src\\main\\resources" +
                    "\\commandList.properties");
            properties.load(reader);
            Enumeration<?> commandNames = properties.propertyNames( );
            while (commandNames.hasMoreElements( )) {
                String stringCurrentCommandName = (String) commandNames.nextElement( );
                CommandEnum currentCommandName = CommandEnum.getCommandEnum(stringCurrentCommandName);
                String pathCurrentCommand = properties.getProperty(stringCurrentCommandName);
                ActionCommand currentCommand = (ActionCommand) Class.forName(pathCurrentCommand).newInstance( );
                factory.put(currentCommandName, currentCommand);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        } catch (IOException e) {
            e.printStackTrace( );
        } catch (IllegalAccessException e) {
            e.printStackTrace( );
        } catch (InstantiationException e) {
            e.printStackTrace( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        }
    }

    public static ActionFactory getInstance() {
        return instance;
    }

    public ActionCommand defineCommand(String typeCommand) {
        if (typeCommand == null || typeCommand.equals("")) {
            return new EmptyCommand( );
        }
        CommandEnum currentEnum = CommandEnum.getCommandEnum(typeCommand);

        return factory.get(currentEnum);
    }

}
