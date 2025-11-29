package com.app.test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.base.RestClient;
import com.app.pojo.request.Place;
import com.app.pojo.response.PlaceResponse;
import com.app.utils.CSVReaderUtil;
import com.app.utils.Data_Passing;

import io.restassured.response.Response;

public class AddPlace_Test {
	
	
	    @Test(dataProviderClass = Data_Passing.class, dataProvider = "placeData" )
	    public void addPlaceTest(String name, String address, String phone, String language) {

	        // ---------- Build Request POJO ----------
	        Place place = new Place();
	        Place.Location loc = new Place.Location();
	        loc.setLat(-38.383494);
	        loc.setLng(33.427362);
	        place.setLocation(loc);

	        place.setAccuracy(50);
	        place.setName(name);
	        place.setPhone_number(phone);
	        place.setAddress(address);
	        place.setTypes(Arrays.asList("shoe park", "shop"));
	        place.setWebsite("http://google.com");
	        place.setLanguage(language);

	        // ---------- Reusable POST Request ----------
	        Response response = RestClient.postRequest("/maps/api/place/add/json", place, "key", "qaclick123");

	        // ---------- Deserialize to POJO ----------
	        PlaceResponse placeResponse = response.as(PlaceResponse.class);

	        // ---------- Dynamic Validation ----------
	        System.out.println("Name: " + name);
	        System.out.println("Status: " + placeResponse.getStatus());
	        System.out.println("Place ID: " + placeResponse.getPlace_id());
	        System.out.println("Reference: " + placeResponse.getReference());
	        System.out.println("----------------------------------");

	        Assert.assertEquals(placeResponse.getStatus(), "OK", "Status validation failed");
	        Assert.assertNotNull(placeResponse.getPlace_id(), "Place ID is null");
	        Assert.assertFalse(placeResponse.getPlace_id().isEmpty(), "Place ID is empty");
	    }
}
