package generators;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class FioGenerator {

    private String lastName;
    private String firstName;
    private String middleName;

    public FioGenerator(final String lastName, final String firstName, final String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
    /**
     * ФИО берутся из соответствующих файлов по индексу в листе:
     * Фамилия - сумма цифр в коде
     * Имя - сумма первых двух цифр
     * Отчество - сумма последних двух цифр.
     *
     * @param code код для генерации
     */
    public final FioGenerator generateParams(final int code) {
        final int lastNameIndex = getDigitsSum(code);
        final String sex = (lastNameIndex % 2 == 0) ? "f" : "m";
        lastName = getLinesFromFile("lastNames_" + sex).get(lastNameIndex);
        firstName = getLinesFromFile("names_" + sex).get(getDigitsSum(code / 100));
        middleName = getLinesFromFile("middleNames_" + sex).get(getDigitsSum(code % 100));
        return new FioGenerator(lastName, firstName, middleName);
    }

    public String printFio(final FioGenerator fioGenerator) {
        return fioGenerator.lastName + " " + fioGenerator.firstName + " " + fioGenerator.middleName;
    }

}

