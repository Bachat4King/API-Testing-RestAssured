package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import utils.PropertiesFile;


/**
 * Base class for all tests.
 */
public abstract class BaseTest {

    /**
     * Initialize RestAssured request specifications.
     */
    @BeforeClass
    public static void setUp() {
        RestAssured.requestSpecification = defaultRequestSpecification();
    }

    /**
     * Create default request specification.
     *
     * @return RequestSpecification
     */
    private static RequestSpecification defaultRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(PropertiesFile.readFile().getProperty("baseUri"))
                .setBasePath(PropertiesFile.readFile().getProperty("basePath"))
                .addFilter(new ErrorLoggingFilter())
                .setContentType(ContentType.JSON)
                .build();
    }

}
