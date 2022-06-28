package builder;

import model.CreateUserRequest;

/**
 * Builder for {@link CreateUserRequest}.
 */
public class CreateUserRequestBuilder {

    private final CreateUserRequest createUserRequest;

    /**
     * Constructor.
     */
    private CreateUserRequestBuilder() {
        createUserRequest = new CreateUserRequest();
    }

    /**
     * Creates a new instance of {@link CreateUserRequestBuilder}.
     *
     * @return a new instance of {@link CreateUserRequestBuilder}.
     */
    public static CreateUserRequestBuilder builder() {
        return new CreateUserRequestBuilder();
    }

    /**
     * Method to chain method calls.
     *
     * @return an instance of {@link CreateUserRequestBuilder}.
     */
    public CreateUserRequestBuilder and() {
        return this;
    }

    /**
     * Method to set the password.
     *
     * @param password the password.
     * @return an instance of {@link CreateUserRequestBuilder}.
     */
    public CreateUserRequestBuilder setPassword(String password) {
        this.createUserRequest.setPassword(password);
        return this;
    }

    /**
     * Method to set the email.
     *
     * @param email the email.
     * @return an instance of {@link CreateUserRequestBuilder}.
     */
    public CreateUserRequestBuilder setEmail(String email) {
        this.createUserRequest.setEmail(email);
        return this;
    }

    /**
     * Method to build the {@link CreateUserRequest}.
     *
     * @return an instance of {@link CreateUserRequest}.
     */
    public CreateUserRequest build() {
        return createUserRequest;
    }

}
