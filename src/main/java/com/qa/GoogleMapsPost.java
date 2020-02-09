package com.qa;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class GoogleMapsPost {

	public static void main(String args[]) {
		
		Places p = new Places();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setWebsite("http://google.com");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setName("Frontline house");
		
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);
		
		
		ArrayList<String> typ = new ArrayList<String>();
		typ.add("shoe park");
		typ.add("shop");		
		p.setTypes(typ);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response resp = given().
		queryParam("key", "qaclick123")
		.body(p)
		.when()
		.post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		System.out.println(resp.asString());
		
		
		
		
	}
	
	
}
