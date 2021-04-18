package person;

public class PersonBuilder {

    private String id;
    private String name;
    private String phys;
    private String appearance;
    private String eyes;
    private String phone;

    public PersonBuilder(final String id) {
        this.id = id;
    }

    public final void withName(final String name) {
        this.name = name;
    }
    public final void withPhys(final String phys) {
        this.phys = phys;
    }
    public final void withAppearance(final String appearance) {
        this.appearance = appearance;
    }
    public final void withEyes(final String eyes) {
        this.eyes = eyes;
    }
    public final void withPhone(final String phone) {
        this.phone = phone;
    }

    public final Person build() {
        final Person person = new Person();
        person.id = this.id;
        person.name = this.name;
        person.phys = this.phys;
        person.appearance = this.appearance;
        person.eyes = this.eyes;
        person.phone = this.phone;
        return person;
    }
}
