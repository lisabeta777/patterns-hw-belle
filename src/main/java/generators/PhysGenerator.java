package generators;

public class PhysGenerator implements Generator {

    private int age;
    private int weight;
    private double height;

    /**
     * Физические параметры генерируются по второй цифре кода:
     * Возраст: 10..100
     * Вес: 30..120 кг
     * Рост: 1..1,9 м.
     * @return
     */
    @Override
    public final String generateParams(final int code) {
        final int i = code % 1000 / 100;
        age = (i + 1) * 10;
        weight = 30 + i * 10;
        height = (100 + i * 10) / 100.00;
        return null;
    }

    @Override
    public final String buildResponse() {
        return String.format("Возраст:\t%1$s%nВес:\t\t%2$s кг%nРост:\t\t%3$s м", age, weight, height);
    }
}
