package model;

/**
 * This class is used to create a UpdateUserRequest object.
 */

public class UpdateUserRequest {
    private String name;
    private String job;

    /**
     * this method is to get the name of the user.
     *
     * @return name of the user.
     */
    public String getName() {
        return name;
    }


    /**
     * this method is to get the job of the user.
     *
     * @return job of the user.
     */
    public String getJob() {
        return job;
    }

    /**
     * this method is to set the name of the user.
     *
     * @param name the name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * this method is to set the job of the user.
     *
     * @param job the job of the user.
     */
    public void setJob(String job) {
        this.job = job;
    }
}
