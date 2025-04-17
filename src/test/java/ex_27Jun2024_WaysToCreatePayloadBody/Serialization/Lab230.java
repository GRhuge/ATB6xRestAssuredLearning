package ex_27Jun2024_WaysToCreatePayloadBody.Serialization;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab230 {
	
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
		
		System.out.println(booking.toString());
		
		Booking booking1 = new Booking();
		booking1.setFirstname("hari");
		booking1.setLastname("ram");
		booking1.setTotalprice(54658);
		booking1.setDepositpaid(true);
		
		BookingDates bookingdates1 = new BookingDates();
		bookingdates1.setCheckin("24-02-01");
		bookingdates1.setCheckout("24-02-05");
		booking.setBookingdates(bookingdates1);
		booking.setAdditionalneeds("Breakfast");
		
		ArrayList payload = new ArrayList();
		payload.add(booking);
		payload.add(booking1);
		payload.add(bookingdates1);
		System.out.println(payload);
		
		r.baseUri(BASE_URL);
		r.basePath(BASE_PATH);
		r.contentType(ContentType.JSON);
		r.log().all().body(booking);
		  
		res=r.when().post();
		String responseString = res.asString();
		System.out.println(responseString);
		  
		validResp=res.then();
		validResp.statusCode(200);
	}
}
