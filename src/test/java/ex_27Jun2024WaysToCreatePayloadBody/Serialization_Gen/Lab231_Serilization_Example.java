package ex_27Jun2024WaysToCreatePayloadBody.Serialization_Gen;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import ex_27Jun2024_WaysToCreatePayloadBody.Serialization.Booking;
import ex_27Jun2024_WaysToCreatePayloadBody.Serialization.BookingDates;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab231_Serilization_Example {
	RequestSpecification r = RestAssured.given();
	Response res;
	ValidatableResponse validResp;
	
	@Description("TC#1 - Verify that create booking is working with valid payload")
	@Test
	public void testNonBDDStylePOSTPositive() {
		String BASE_URL = "https://restful-booker.herokuapp.com";
		String BASE_PATH = "/booking";
	
		Booking booking = new Booking();
		booking.setFirstname("krsna");
		booking.setLastname("ram");
		booking.setTotalprice(-354658);
		booking.setDepositpaid(true);
		booking.setAdditionalneeds("Breakfast");
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("24-02-01");
		bookingdates.setCheckout("24-02-05");
		booking.setBookingdates(bookingdates);
		
		System.out.println(booking);
		
		//Serilizaion - from line 42 to 44 we have converted java object(POJO) to JSONString
		
		Gson gs = new Gson();
		String jsonStringPayLoad = gs.toJson(booking);
		System.out.println(jsonStringPayLoad);
 }
}
