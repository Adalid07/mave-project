package com.rev.cat.catservice.Buyer;

import com.google.gson.JsonObject;
import com.rev.cat.catservice.config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@ContextConfiguration(classes = {Config.class})
@TestPropertySource("classpath:application.properties")
public class BuyerRestTest {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    private Config config;

    @Before
    public void setup() {
        RestAssured.baseURI = config.getUrl();
        RestAssured.port = config.getPort();
    }

    @Test
    public void InitializeNewExplanation() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = request.get("/buyers");
        int code = response.getStatusCode();
        Assert.assertEquals(200, code);
    }

    @Test
    public void createNewBrandTest() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JsonObject requestParams = new JsonObject();

        requestParams.addProperty("description", "CODE-001");
        requestParams.addProperty("date", "BRAND-001");
        requestParams.addProperty("taxes", "DESCRIPTION-001");
        requestParams.addProperty("customsTaxes", "DESCRIPTION-001");
        requestParams.addProperty("importTaxes", "DESCRIPTION-001");
        requestParams.addProperty("totalCost", "DESCRIPTION-001");
        requestParams.addProperty("price", "DESCRIPTION-001");
        requestParams.addProperty("stock", "DESCRIPTION-001");
        requestParams.addProperty("productId", "DESCRIPTION-001");
        request.body(requestParams.toString());
        Response response = request.post("/buyers");
        int code = response.getStatusCode();
        Assert.assertEquals(201, code);
    }
}
