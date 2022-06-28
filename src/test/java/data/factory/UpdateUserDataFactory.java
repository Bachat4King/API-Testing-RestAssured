package data.factory;

import com.github.javafaker.Faker;
import model.UpdateUserRequest;
import utils.PropertiesFile;

import static builder.UpdateUserRequestBuilder.builder;

/**
 * This class is used to create a data for the UpdateUserRequest object.
 */
public class UpdateUserDataFactory {

    private static final Faker faker = new Faker();
    private static final String DEFAULT_JOB = PropertiesFile.readFile().getProperty("DEFAULT_JOB");

    /**
     * this method is to create data with valid information
     *
     * @return UpdateUserRequest object
     */
    public static UpdateUserRequest validUser() {
        return builder()
                .setName(faker.name().name())
                .and()
                .setJob(faker.name().title())
                .build();
    }

    /**
     * this method is to create data with name and default job
     *
     * @return UpdateUserRequest object
     */
    public static UpdateUserRequest onlyName() {
        return builder()
                .setName(faker.name().name())
                .and()
                .setJob(DEFAULT_JOB)
                .build();
    }
}
