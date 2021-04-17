import java.nio.charset.Charset;
import java.util.Scanner;

public final class Controller {

    private static Controller instance;
    private Controller() { };
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    private final InputProcessor processor = new InputProcessor();
    public void launch() {
        Scanner scanner = new Scanner(System.in, Charset.defaultCharset());
        String input;
        while (true) {
            System.out.println("Введите 4 цифры от 0 до 9 без пробелов (Q для выхода)");
            input = scanner.nextLine();
            if ("q".equalsIgnoreCase(input)) {
                break;
            } else {
                System.out.println(processor.processInput(input));
                System.out.println("------------");
            }
        }
        scanner.close();
    }
}
