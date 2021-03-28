package generators;
import utils.MyMath;

import java.util.Random;

public class PhoneGenerator implements Generator {

    private String number;

    /**
     * Номер телефона генерируется следующим образом:
     * +79[сумма цифр в коде][3 случайных числа][код].
     * @return
     */

    public final String generateParams(final int code) {
        number = "+79"
                + String.format("%02d", MyMath.getDigitsSum(code))
                + String.format("%03d", new Random().nextInt(1000))
                + String.format("%04d", code);
        return null;
    }

  @Override
    public final String buildResponse() {
        return  "Телефон:\t" + number;
    }
}

