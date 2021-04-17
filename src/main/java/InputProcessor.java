import generators.*;
import person.Person;

public class InputProcessor {

    public final String processInput(final String input) {
        String result;

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person
            final int intCode = Integer.parseInt(input);

            final FioGenerator fioGenerator = new FioGenerator(null, null, null);
            FioGenerator fio = fioGenerator.generateParams(intCode);

            final PhysGenerator physGenerator = new PhysGenerator();
            physGenerator.generateParams(intCode);
            final String physical = physGenerator.buildResponse();

            final HairGenerator hairGenerator = new HairGenerator();
            hairGenerator.generateParams(intCode);
            final String appearance = hairGenerator.buildResponse();

            final EyesGenerator eyesGenerator = new EyesGenerator();
            eyesGenerator.generateParams(intCode);
            final String eyes = eyesGenerator.buildResponse();

            String phone = null;
            // добавляем телефон, только если введённый код не палиндром
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                final PhoneGenerator phoneGenerator = new PhoneGenerator();
                phoneGenerator.generateParams(intCode);
                phone = phoneGenerator.buildResponse();
            }

            result = new Person(input,
                    fio.printFio(fio),
                    physical,
                    appearance,
                    eyes,
                    phone
                    ).toString();
        } else {
            result = "Неверный ввод.";
        }
        return result;
    }
}
