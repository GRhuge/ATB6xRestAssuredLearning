package ex_27Jun2024WaysToCreatePayloadBody_Deserilization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import ex_27Jun2024_WaysToCreatePayloadBody.Serialization.Booking;

public class Lab232_Deserilization_Example {
	
	@Test
	public void DeSerilization() {
		String jsonString = "{\n" +
		        "   \"lastname\": \"Brown\",\n" +
		        "   \"firstname\": \"Jim\",\n" +
		        "   \"totalprice\": 111,\n" +
		        "   \"depositpaid\": true,\n" +
		        "   \"bookingdates\": {\n" +
		        "      \"checkin\": \"2018-01-01\",\n" +
		        "      \"checkout\": \"2018-01-01\"\n" +
		        "    },\n" +
		        "   \"additionalneeds\":\"Breakfast\"\n" +
				"}";
		
		Gson gs = new Gson();
		Booking booking = gs.fromJson(jsonString,Booking.class);
		System.out.println(booking.toString());
		System.out.println(booking.getLastname());
		
		Assert.assertEquals(booking.getFirstname(),"Jim");
	}	
}
