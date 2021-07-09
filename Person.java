package builder_patterns1;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = Integer.MAX_VALUE;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setAge(int age) {
        if (!hasAge()) {
            this.age = age;
        }
    }

    public void setAddress(String address) {
        if (!hasAdress()) {
            this.address = address;
        }
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    private boolean hasAge() {
        return this.age != Integer.MAX_VALUE;
    }

    private boolean hasAdress() {
        return this.address != null;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
