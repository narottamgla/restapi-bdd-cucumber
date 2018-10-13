package com.googleapi.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

	@SerializedName("address_components")
	@Expose
	private List<AddressComponent> addressComponents = null;
	@SerializedName("formatted_address")
	@Expose
	private String formattedAddress;
	@SerializedName("geometry")
	@Expose
	private Geometry geometry;
	@SerializedName("place_id")
	@Expose
	private String placeId;
	@SerializedName("plus_code")
	@Expose
	private PlusCode plusCode;
	@SerializedName("types")
	@Expose
	private List<String> types = null;

	public List<AddressComponent> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(List<AddressComponent> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public PlusCode getPlusCode() {
		return plusCode;
	}

	public void setPlusCode(PlusCode plusCode) {
		this.plusCode = plusCode;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}
}
