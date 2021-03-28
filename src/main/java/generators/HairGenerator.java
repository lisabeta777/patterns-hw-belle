package generators;

import java.util.HashMap;

public class HairGenerator implements Generator {

    private String hairLength;
    private String hairColor;

    /**
     * Внешность генерируется по третьей цифре кода (i):
     * Длина волос: i
     * Цвет волос: из enum по индексу i-1 при i>0 (=0..8).
     * @return
     */
    @Override
    public final String generateParams(final int code) {
        final int i = code % 100 / 10;

        final HashMap<Integer, String> hairColorMap = new HashMap<>() {{
            put(1, "чёрные");
            put(2, "каштановые");
            put(3, "рыжие");
            put(4, "светлые");
            put(5, "седые");
            put(6, "розовые");
            put(7, "зелёные");
            put(8, "фиолетовые");
            put(9, "синие");
        }};
        if (i > 0) {
            hairColor = hairColorMap.get(i);
            if (i > 4) {
                hairLength = "длинные, ";
            } else {
                hairLength = "короткие, ";
            }
        }
        if (i == 0) {
            hairLength = "нет";
        hairColor = "";
        }
        return null;
    }

    @Override
    public final String buildResponse() {
        return String.format("Волосы:\t\t%1$s",  hairLength +  hairColor);
    }
}
