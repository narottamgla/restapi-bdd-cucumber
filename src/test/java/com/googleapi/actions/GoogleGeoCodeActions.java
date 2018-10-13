package com.googleapi.actions;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googleapi.models.GeoCoding;
import com.googleapi.models.Result;
import com.googleapi.utils.Constants;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GoogleGeoCodeActions {

	public Response response;
	public GeoCoding geoCoding;

	@Step
	public void requestGoogleGeoWithGet(String apiKey, String address) throws Exception {
		response = SerenityRest.given()
				   .queryParam("address",address)
                   .queryParam("sensor","false")
                   .queryParam("key",apiKey)
                   .when()
                   .get(Constants.GOOGLE_GEOCODE_ENDPOINTS);
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.setPrettyPrinting().create();
		geoCoding = gson.fromJson(response.getBody().prettyPrint(), GeoCoding.class);
	}
	
	@Step
	public void requestReverseGoogleGeoWithGet(String apiKey, String lat, String lang) throws Exception {
		System.out.println("1:" + lat);
		System.out.println("2: "+lang);

		response = SerenityRest.given()
				   .queryParam("latlng",lat+","+lang)
              //     .queryParam("sensor","false")
                   .queryParam("key",apiKey)
                   .when()
                   .get(Constants.GOOGLE_GEOCODE_ENDPOINTS);
		//response.get
		System.out.println(response);
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.setPrettyPrinting().create();
		geoCoding = gson.fromJson(response.getBody().prettyPrint(), GeoCoding.class);
	}

	@Step
	public int getStatusCode() throws Exception {
		return response.then().extract().statusCode();
	}

	@Step
	public String getContentType() throws Exception {
		return response.then().extract().contentType();
	}
	
	@Step
	public List<Result> getResultNode() throws Exception {
		return geoCoding.getResults();
	}
	
	@Step
	public String getResultStatus() throws Exception {
	   return geoCoding.getStatus();
	}
	
	@Step
	public Result getGeoResult() throws Exception {
		return geoCoding.getResults().get(0);	
	}
}
