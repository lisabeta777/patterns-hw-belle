package person;

public class Person {

    private final String id;
    private final String name;
    private final String phys;
    private final String appearance;
    private final String eyes;
    private final String phone;


    public Person(final String id,
                  final String name,
                  final String phys,
                  final String appearance,
                  final String eyes,
                  final String phone
                  ) {
        this.id = id;
        this.name = name;
        this.phys = phys;
        this.appearance = appearance;
        this.eyes = eyes;
        this.phone = phone;
    }


    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(name).append("\n")
                .append(phys).append("\n")
                .append(eyes).append("\n")
                .append(appearance).append("\n");

        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }
}