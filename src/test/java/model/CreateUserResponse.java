package model;

/**
 * This class is used create a CreateUserResponse object from the response.
 */

public class CreateUserResponse {
    private int id;
    private String token;

    /**
     * this method is to get the id of the user.
     *
     * @return id of the user.
     */
    public int getId() {
        return id;
    }

    /**
     * this method is to get the token of the user.
     *
     * @return the token of the user.
     */
    public String getToken() {
        return token;
    }
}
