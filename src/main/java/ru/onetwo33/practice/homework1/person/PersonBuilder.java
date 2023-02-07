package ru.onetwo33.practice.homework1.person;

public class PersonBuilder {

    private final Person person = new Person();

    public PersonBuilder withFirstName(String firstName) {
        this.person.setFirstName(firstName);
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.person.setLastName(lastName);
        return this;
    }

    public PersonBuilder withMiddleName(String middleName) {
        this.person.setMiddleName(middleName);
        return this;
    }

    public PersonBuilder withCountry(String country) {
        this.person.setCountry(country);
        return this;
    }

    public PersonBuilder withAddress(String address) {
        this.person.setAddress(address);
        return this;
    }

    public PersonBuilder withPhone(String phone) {
        this.person.setPhone(phone);
        return this;
    }

    public PersonBuilder withAge(int age) {
        this.person.setAge(age);
        return this;
    }

    public PersonBuilder withGender(String gender) {
        this.person.setGender(gender);
        return this;
    }

    public Person build() {
        return person;
    }
}