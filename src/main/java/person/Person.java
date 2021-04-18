package person;

public class Person {

    public String id;
    public String name;
    public String phys;
    public String appearance;
    public String eyes;
    public String phone;

    @Override
    public String toString() {
        return id + '\n' + name + '\n' + phys + '\n' +  eyes + '\n' + appearance + '\n' +  phone;
    }
}