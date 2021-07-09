package builder_patterns1;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = Integer.MAX_VALUE;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Возраст не может быть меньше нуля!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (!isMandatoryFieldsFilled()) {
            throw new IllegalStateException("Поля name и surname должны быть заполнены!");
        }
        Person person = new Person(name, surname);

        if (age != Integer.MAX_VALUE) {
            person.setAge(age);
        }
        if (address != null) {
            person.setAddress(address);
        }

        return person;
    }

    private boolean isMandatoryFieldsFilled() {
        return name != null && surname != null;
    }
}
