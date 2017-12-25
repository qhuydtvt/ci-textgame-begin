import bases.events.EventManager;
import bases.inputs.CommandListener;
import bases.inputs.InputManager;

/**
 * Created by huynq on 7/28/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();

        EventManager.pushUIMessageNewLine("Hello");
        EventManager.pushUIMessageNewLine("This is TechKids' Text Game GUI Demo");
        EventManager.pushUIMessageNewLine("Type any text show it in the view panel");
        EventManager.pushUIMessageNewLine("Type 'clear' to clear the view panel ");

        InputManager.instance.addCommandListener(new CommandListener() {
            @Override
            public void onCommandFinished(String command) {
                if (!command.equalsIgnoreCase("clear")) {
                    EventManager.pushUIMessageNewLine("New command:");
                    EventManager.pushUIMessageNewLine(command);
                } else {
                    EventManager.pushClearUI();
                }
            }

            @Override
            public void commandChanged(String command) {

            }
        });


        gameWindow.gameLoop();
    }
}
