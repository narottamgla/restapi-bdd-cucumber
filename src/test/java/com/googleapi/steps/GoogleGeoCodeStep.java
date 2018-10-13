package com.googleapi.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;

import com.googleapi.actions.GoogleGeoCodeActions;
import com.googleapi.utils.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GoogleGeoCodeStep {

	@Steps
	GoogleGeoCodeActions googleGeoCodeActions;

	String apiKey;
	String address;
	String lat;
	String lang;

	@Given("^The user have proper API key$")
	public void the_user_have_proper_API_key() throws Exception {
		apiKey = Constants.GOOGLE_API_KEY;
	}

	@Given("^Have valid location address as \"([^\"]*)\"$")
	public void have_valid_location_address_as(String arg1) throws Exception {
		address = arg1;
	}

	@When("^The user sents GET request to google Geocoding API with API key$")
	public void the_user_sents_GET_request_to_google_Geocoding_API_with_API_key() throws Exception {
		googleGeoCodeActions.requestGoogleGeoWithGet(apiKey, address);
	}
	
	@Given("^Have valid location lat as \"([^\"]*)\"$")
	public void have_valid_location_lat_as(String arg1) throws Exception {
		lat = arg1;
	}

	@Given("^Have valid location lang as \"([^\"]*)\"$")
	public void have_valid_location_lang_as(String arg1) throws Exception {
		lang = arg1;
	}

	@When("^The user sents GET request to google Reverse Geocoding API with API key$")
	public void the_user_sents_GET_request_to_google_Reverse_Geocoding_API_with_API_key() throws Exception {
		googleGeoCodeActions.requestReverseGoogleGeoWithGet(apiKey, lat, lang);
	}

	@Then("^API should return status as (\\d+)$")
	public void api_should_return_status_as(int statusCode) throws Exception {
		assertThat("Verify Status code for GeoCoding Api ", googleGeoCodeActions.getStatusCode(), equalTo(statusCode));
	}

	@Then("^Response content type should be json$")
	public void response_content_type_should_be_json() throws Exception {
		assertThat("Verify Content Type for GeoCoding Api ", googleGeoCodeActions.getContentType(),
				equalTo("application/json; charset=UTF-8"));
	}

	@Then("^Response should have result node$")
	public void response_should_have_result_node() throws Exception {
		assertThat("Verify Result for GeoCoding Api ", googleGeoCodeActions.getResultNode().size(),
				greaterThanOrEqualTo(1));
	}

	@Then("^Result should have status as \"([^\"]*)\"$")
	public void result_should_have_status_as(String arg1) throws Exception {
		assertThat("Verify Status code for GeoCoding Api ", googleGeoCodeActions.getResultStatus(), equalTo(arg1));
	}

	@Then("^Result should have formatted address as \"([^\"]*)\"$")
	public void result_should_have_formatted_address_as(String arg1) throws Exception {
		assertThat("Verify formatted address for GeoCoding Api ",
				googleGeoCodeActions.getGeoResult().getFormattedAddress(), equalTo(arg1));
	}

	@Then("^Result should have address_components$")
	public void result_should_have_address_components() throws Exception {
		assertThat("Verify Result for address_components ",
				googleGeoCodeActions.getGeoResult().getAddressComponents().size(), greaterThanOrEqualTo(1));
	}

	@Then("^Result should have geometry$")
	public void result_should_have_geometry() throws Exception {
		assertThat("Verify Result for geometry", hasItem(googleGeoCodeActions.getGeoResult().getGeometry()) != null);
	}

	@Then("^Geo metry should have location lat as \"([^\"]*)\"$")
	public void geo_metry_should_have_location_lat_as(String arg1) throws Exception {
		assertThat("Geo metry should have location lat as",
				googleGeoCodeActions.getGeoResult().getGeometry().getLocation().getLat().toString(), equalTo((arg1)));
	}

	@Then("^Geo metry should have location lng as \"([^\"]*)\"$")
	public void geo_metry_should_have_location_lng_as(String arg1) throws Exception {
		assertThat("Geo metry should have location lng as",
				googleGeoCodeActions.getGeoResult().getGeometry().getLocation().getLng().toString(), equalTo((arg1)));
	}

	@Then("^Geo metry should have location_type \"([^\"]*)\"$")
	public void geo_metry_should_have_location_type(String arg1) throws Exception {
		assertThat("Geo metry should have location_type",
				googleGeoCodeActions.getGeoResult().getGeometry().getLocationType(), equalTo((arg1)));
	}

	@Then("^Geo metry should view port northeast$")
	public void geo_metry_should_view_port_northeast() throws Exception {
		assertThat("Geo metry should view port northeast",
				hasItem(googleGeoCodeActions.getGeoResult().getGeometry().getViewport().getNortheast()) != null);
	}

	@Then("^Geo metry should view port southwest$")
	public void geo_metry_should_view_port_southwest() throws Exception {
		assertThat("Geo metry should view port southwest",
				hasItem(googleGeoCodeActions.getGeoResult().getGeometry().getViewport().getSouthwest()) != null);
	}

	@Then("^Northeast should have lat as \"([^\"]*)\"$")
	public void northeast_should_have_lat_as(String arg1) throws Exception {
		assertThat("Northeast should have lat",
				googleGeoCodeActions.getGeoResult().getGeometry().getViewport().getNortheast().getLat().toString(), equalTo((arg1)));
	}

	@Then("^Northeast should have lng as \"([^\"]*)\"$")
	public void northeast_should_have_lng_as(String arg1) throws Exception {
		assertThat("northeast_should_have_lng_as",
				googleGeoCodeActions.getGeoResult().getGeometry().getViewport().getNortheast().getLng().toString(), equalTo((arg1)));
	}

	@Then("^Southwest should have lat as \"([^\"]*)\"$")
	public void southwest_should_have_lat_as(String arg1) throws Exception {
		assertThat("Southwest should have lat as",
				googleGeoCodeActions.getGeoResult().getGeometry().getViewport().getSouthwest().getLat().toString(), equalTo((arg1)));
	}

	@Then("^Southwest should have lng as \"([^\"]*)\"$")
	public void southwest_should_have_lng_as(String arg1) throws Exception {
		assertThat("Southwest should have lng as",
				googleGeoCodeActions.getGeoResult().getGeometry().getViewport().getSouthwest().getLng().toString(), equalTo((arg1)));
	}
}
