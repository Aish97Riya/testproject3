package apitestpkg;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apitestcls {
	static RequestSpecBuilder reqspec=new RequestSpecBuilder();

@Test(priority=1)
public static void post()
{
	RequestSpecification postreq=reqspec.setBaseUri("https://petstore.swagger.io/v2/pet").addHeader("accpet","application/json").addHeader("Content-Type","application/json").setBody("{\r\n"
			+ "  \"id\": 7103,\r\n"
			+ "  \"category\": {\r\n"
			+ "    \"id\": 0,\r\n"
			+ "    \"name\": \"string\"\r\n"
			+ "  },\r\n"
			+ "  \"name\": \"bunny\",\r\n"
			+ "  \"photoUrls\": [\r\n"
			+ "    \"string\"\r\n"
			+ "  ],\r\n"
			+ "  \"tags\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 0,\r\n"
			+ "      \"name\": \"string\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"status\": \"out of stock\"\r\n"
			+ "}").setUrlEncodingEnabled(false).build();
	Response postresp=RestAssured.given().spec(postreq).post();
	System.out.println(postresp.getBody().asString());
	System.out.println(postresp.getStatusCode());	
	assertEquals(postresp.getStatusCode(),200);
}
@Test(priority=3)
public static void put()
{
	RequestSpecification putreq=reqspec.setBaseUri("https://petstore.swagger.io/v2/pet").addHeader("accept","application/json").addHeader("Content-Type","application/json").setBody("{\r\n"
			+ "  \"id\": 7102,\r\n"
			+ "  \"category\": {\r\n"
			+ "    \"id\": 0,\r\n"
			+ "    \"name\": \"string\"\r\n"
			+ "  },\r\n"
			+ "  \"name\": \"kitten\",\r\n"
			+ "  \"photoUrls\": [\r\n"
			+ "    \"string\"\r\n"
			+ "  ],\r\n"
			+ "  \"tags\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 0,\r\n"
			+ "      \"name\": \"string\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"status\": \"available\"\r\n"
			+ "}").setUrlEncodingEnabled(false).build();
	Response putresp=RestAssured.given().spec(putreq).put();
	System.out.println(putresp.getBody().asString());
	System.out.println(putresp.getStatusCode());
	assertEquals(putresp.getStatusCode(),200);
}
@Test(priority=2)
public static void get()
{
	RequestSpecification getreq=reqspec.setBaseUri("https://petstore.swagger.io/v2/pet/7103").addHeader("accept","application/json").setUrlEncodingEnabled(false).build();
	Response getresp=RestAssured.given().spec(getreq).get();
	System.out.println(getresp.getBody().asString());
	System.out.println(getresp.getStatusCode());
	assertEquals(getresp.getStatusCode(),200);
}
@Test(priority=4)
public static void delete()
{
	RequestSpecification delreq=reqspec.setBaseUri("https://petstore.swagger.io/v2/pet/7102").addHeader("accept","application/json").setUrlEncodingEnabled(false).build();
	Response delresp=RestAssured.given().spec(delreq).delete();
	System.out.println(delresp.getBody().asString());
	System.out.println(delresp.getStatusCode());
	assertEquals(delresp.getStatusCode(),200);
}
}
