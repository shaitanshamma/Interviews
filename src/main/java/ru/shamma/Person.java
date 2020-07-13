package ru.shamma;

public class Person {
    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    int age;
    String gender;

    public Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.country = builder.country;
        this.address = builder.address;
        this.phone = builder.phone;
        this.age = builder.age;
        this.gender = builder.gender;
    }

    static class Builder {
        String firstName;
        String lastName;
        String middleName;
        String country;
        String address;
        String phone;
        int age;
        String gender;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }
        public void info() {
            System.out.println("Person:" + "\n" + "firstname - " + firstName + "\n" +
                    "lastname - " + lastName + "\n" +
                    "middleName - " + middleName + "\n" +
                    "country - " + country + "\n" +
                    "address - " + address + "\n" +
                    "phone - " + phone + "\n" +
                    "age - " + age + "\n" +
                    "gender - " + gender + "\n");
            System.out.println("********************");
        }
}
