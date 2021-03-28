package generators;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;
public class FioGenerator implements Generator {

    private String lastName;
    private String firstName;
    private String middleName;

    /**
     * ФИО берутся из соответствующих файлов по индексу в листе:
     * Фамилия - сумма цифр в коде
     * Имя - сумма первых двух цифр
     * Отчество - сумма последних двух цифр.
     *
     * @param code код для генерации
     * @return
     */
    @Override
    public final String generateParams(final int code) {
        final int lastNameIndex = getDigitsSum(code);
        final String sex = (lastNameIndex % 2 == 0) ? "f" : "m";
        setLastNameFromFile(lastNameIndex, sex);
        setFirstNameFromFile(getDigitsSum(code / 100), sex);
        setMiddleNameFromFile(getDigitsSum(code % 100), sex);
        return sex;
    }
    @Override
    public final String buildResponse() {
        return lastName + " " + firstName + " " + middleName;
    }

    private void setLastNameFromFile(final int i, final String sex) {
        lastName = getLinesFromFile("lastNames_" + sex).get(i);
    }

    private void setFirstNameFromFile(final int i, final String sex) {
        firstName = getLinesFromFile("names_" + sex).get(i);
    }

    private void setMiddleNameFromFile(final int i, final String sex) {
        middleName = getLinesFromFile("middleNames_" + sex).get(i);
    }
}

