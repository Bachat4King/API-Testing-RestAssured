package data.factory;

import com.github.javafaker.Faker;
import model.CreateUserRequest;
import utils.PropertiesFile;

import static builder.CreateUserRequestBuilder.builder;

/**
 * This class is used to create a data for the CreateUserRequest object.
 */
public class CreateUserDataFactory {

    private static final Faker faker = new Faker();
    private static final String DEFAULT_EMAIL = PropertiesFile.readFile().getProperty("DEFAULT_EMAIL");

    /**
     * this method is to create data with null information
     *
     * @return CreateUserRequest object
     */
    public static CreateUserRequest nullInformation() {
        return builder()
                .setEmail(null)
                .and()
                .setPassword(null)
                .build();
    }

    /**
     * this method is to create valid data
     *
     * @return CreateUserRequest object
     */
    public static CreateUserRequest validUser() {
        return builder()
                .setEmail(DEFAULT_EMAIL)
                .and()
                .setPassword(faker.internet().password())
                .build();
    }

}
