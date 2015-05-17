package netshoes.ex1e2.service;

import javax.inject.Inject;





import netshoes.ex1e2.model.ZipcodeAddress;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class ZipcodeServiceTest{

	@Inject
	private ZipcodeService zipcodeService;
	
	
	
	@Test
	public void testReplaceCharInPositionByZero(){
		String zipcode = "12345678";
		
		Assert.assertEquals("12345670", zipcodeService.replaceCharInPositionByZero(zipcode, 7));
		Assert.assertEquals("12345608", zipcodeService.replaceCharInPositionByZero(zipcode, 6));
		Assert.assertEquals("12345078", zipcodeService.replaceCharInPositionByZero(zipcode, 5));
		Assert.assertEquals("12340678", zipcodeService.replaceCharInPositionByZero(zipcode, 4));
		Assert.assertEquals("12305678", zipcodeService.replaceCharInPositionByZero(zipcode, 3));
		Assert.assertEquals("12045678", zipcodeService.replaceCharInPositionByZero(zipcode, 2));
		Assert.assertEquals("10345678", zipcodeService.replaceCharInPositionByZero(zipcode, 1));
		Assert.assertEquals("02345678", zipcodeService.replaceCharInPositionByZero(zipcode, 0));
		
	}
	
	
	@Test
	public void testIsZipcodeValid(){
		String zipcode = "12312312";
		Assert.assertTrue(zipcodeService.isZipcodeValid(zipcode));
	}
	
	
	@Test
	public void testIsZipcodeValidWhenInvalidZipcode(){
		String zipcode = "123123";
		Assert.assertFalse(zipcodeService.isZipcodeValid(zipcode));
	}
	
	@Test
	public void testGetZipcodeAddressWhenZipcodeExists(){
		String zipcode = "05402000";
		
		ZipcodeAddress result = zipcodeService.getZipcodeAddress(zipcode);
		Assert.assertNotNull(result);
		
		Assert.assertEquals("Avenida Rebouças", result.getStreet());
		Assert.assertEquals("Pinheiros", result.getDistrict());
		Assert.assertEquals("São Paulo", result.getCity());
		Assert.assertEquals("SP", result.getState());
	}
	
	
	@Test
	public void testGetZipcodeWhenZipcodeDoesNotExist(){
		String zipcode = "12121212";
		
		ZipcodeAddress result = zipcodeService.getZipcodeAddress(zipcode);
		Assert.assertNull(result);
	}
	
	
	
	@Test
	public void testGetZipcodeWhenLastDigitsAreReplacedByZeroes(){
		String zipcode = "05402123";		//will have last digits replaced by 0
		ZipcodeAddress result = zipcodeService.getZipcodeAddress(zipcode);
		Assert.assertNotNull(result);
		
		Assert.assertEquals("Avenida Rebouças", result.getStreet());
		Assert.assertEquals("Pinheiros", result.getDistrict());
		Assert.assertEquals("São Paulo", result.getCity());
		Assert.assertEquals("SP", result.getState());
	}
	
	
}
