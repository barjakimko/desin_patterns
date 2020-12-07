package org.example.creational;

import java.util.ArrayList;
import java.util.List;
//
//  Założenia:
//  Buldier jest wykorzystywany do zooptymalizowania dużych
//  obiektów (z wieloma polami opcjonalnymi). Aby nie stosować
//  wielu przeładowanych konstuktowrów, gdzie istnieje przeka-
//  zanie nulli na produkcje- stosuję się Builder.
//  Są dwa sposoby wprowadzenia buldiera:
//  1. Jako osobna klasa.
//  2. Jako methoda dla danej klasy.
//  Metoda builder powinna być statyczną metodą, która przypomi-
//  stream- czyli daję nam przepis na obiekt.
//  Wykonanie:
//  1. Stworzyć prywatny konstrukor, który przyjmuję obiekt BUILDER
//  2. Stworzyć wewnętrzną klase Builder, która domyślnie przyjmuję
//     zadane pola.
//  3. Stowrzyć metodyć metody (coś ala setery) do ustawiania pól,
//     które zwracają obiekt wewnętrznej klasy (builder).
//  4. Stowrzyć w wenętrznej klasie metodę build, która wywoła pry-
//     watny konstuktor, przyjując jako argument obiet wew. klasy!!

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String login;
    private List<String> categories;
    private List<Integer> transaction;

    private User(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.login = builder.login;
        this.categories = builder.categories;
        this.transaction = builder.transaction;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id = 0L;
        private String firstName = "Unknown";
        private String lastName = "Unknown";
        private String email = "Unknown";
        private String password = "Unknown";
        private String login = "Unknown";
        private List<String> categories = new ArrayList<>();
        private List<Integer> transaction = new ArrayList<>();

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.firstName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder withCategories(List<String> categories) {
            this.categories = categories;
            return this;
        }

        public Builder withTransaction(List<Integer> transaction) {
            this.transaction = transaction;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", categories=" + categories +
                ", transaction=" + transaction +
                '}';
    }

    public static void main(String[] args) {

        User user = User.builder()
                .withEmail("bj@mail.com")
                .withId(1L)
                .withFirstName("BJ")
                .build();

        System.out.println(user.toString());
        //powinien przypisac tylko maila, imie i id= 1.
    }
}
