package model;

/**
 * This class is used to create a CreateUserRequest object.
 */

public class CreateUserRequest {
    private String password;
    private String email;

    /**
     * this method is to get the password of the user.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * this method is to set the password of the user.
     *
     * @param password the password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * this method is to get the email of the user.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * this method is to set the email of the user.
     *
     * @param email the email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
