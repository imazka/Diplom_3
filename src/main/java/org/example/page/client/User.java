package org.example.page.client;

import com.github.javafaker.Faker;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String email;
    private String name;
    private String password;
    private transient String jwt;

    public User() {

        Faker faker = new Faker();
        this.name = faker.name().firstName();
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password();

    }

}
