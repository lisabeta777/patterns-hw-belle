package generators;

public class EyesGenerator implements Generator {

    private String eyes;

    /**
     * Внешность генерируется по третьей цифре кода (i):
     * Глаза: по индексу i/2 (=0..4)
     * @return
     */
    @Override
    public final String generateParams(final int code) {
        final int i = code % 100 / 10;
        switch (i / 2) {
            case 0:
                eyes = "голубые";
                break;
            case 1:
                eyes = "зелёные";
                break;
            case 2:
                eyes = "карие";
                break;
            case 3:
                eyes = "серые";
                break;
            case 4:
                eyes = "разные";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i / 2);
        }
        return eyes;
    }

        @Override
        public final String buildResponse() {
            return String.format("Глаза:\t\t%1$s",  eyes);
        }

}

