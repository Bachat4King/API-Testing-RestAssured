package builder;

import model.UpdateUserRequest;

/**
 * Builder for {@link UpdateUserRequest}.
 */
public class UpdateUserRequestBuilder {

    private final UpdateUserRequest updateUserRequest;

    /**
     * Constructor.
     */
    private UpdateUserRequestBuilder() {
        updateUserRequest = new UpdateUserRequest();
    }

    /**
     * Creates a new instance of {@link UpdateUserRequestBuilder}.
     *
     * @return a new instance of {@link UpdateUserRequestBuilder}.
     */
    public static UpdateUserRequestBuilder builder() {
        return new UpdateUserRequestBuilder();
    }

    /**
     * Method to chain method calls.
     *
     * @return an instance of {@link UpdateUserRequestBuilder}.
     */
    public UpdateUserRequestBuilder and() {
        return this;
    }

    /**
     * Method to set the name.
     *
     * @param name the name.
     * @return an instance of {@link UpdateUserRequestBuilder}.
     */
    public UpdateUserRequestBuilder setName(String name) {
        this.updateUserRequest.setName(name);
        return this;
    }

    /**
     * Method to set the job.
     *
     * @param job the job.
     * @return an instance of {@link UpdateUserRequestBuilder}.
     */
    public UpdateUserRequestBuilder setJob(String job) {
        this.updateUserRequest.setJob(job);
        return this;
    }

    /**
     * Method to build the {@link UpdateUserRequest}.
     *
     * @return an instance of {@link UpdateUserRequest}.
     */
    public UpdateUserRequest build() {
        return updateUserRequest;
    }

}
