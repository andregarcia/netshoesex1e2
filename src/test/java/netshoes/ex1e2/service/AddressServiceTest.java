package netshoes.ex1e2.service;

import javax.inject.Inject;

import netshoes.ex1e2.exception.InvalidZipcodeException;
import netshoes.ex1e2.model.Address;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class AddressServiceTest {

	
	@Inject
	private AddressService addressService;
	
	
	
	@Test
	public void testCreateAddressWithValidZipcode() throws InvalidZipcodeException {
		Address address = new Address(null, "Avenida Paulista", "123", "01311000",  "São Paulo", "SP", "Bela Vista", "Loja 2");
		Address addressAfterCreate = addressService.createAddress(address);
		
		//assert id was generated
		Assert.assertNotNull(addressAfterCreate.getId());
		
		//get address and check if is created with defined values
		Address addressAfterGet = addressService.getAddress(address.getId());
		Assert.assertEquals(addressAfterCreate.getId(), addressAfterGet.getId());
		Assert.assertEquals(address.getStreet(), addressAfterGet.getStreet());
		Assert.assertEquals(address.getNumber(), addressAfterGet.getNumber());
		Assert.assertEquals(address.getZipcode(), addressAfterGet.getZipcode());
		Assert.assertEquals(address.getCity(), addressAfterGet.getCity());
		Assert.assertEquals(address.getState(), addressAfterGet.getState());
		Assert.assertEquals(address.getDistrict(), addressAfterGet.getDistrict());
		Assert.assertEquals(address.getComplement(), addressAfterGet.getComplement());
		
		//delete address
		addressService.deleteAddress(addressAfterGet.getId());
		
	}
	
	
	@Test(expected=InvalidZipcodeException.class)
	public void testCreateAddressWithInvalidZipcode() throws InvalidZipcodeException {
		Address address = new Address(null, "Avenida Paulista", "123", "01511000",  "São Paulo", "SP", "Bela Vista", "Loja 2");
		addressService.createAddress(address);
	}
	
	
	@Test
	public void testGetAddress() throws InvalidZipcodeException{
		Address address = new Address(null, "Avenida Paulista", "123", "01311000",  "São Paulo", "SP", "Bela Vista", "Loja 2");
		addressService.createAddress(address);
		
		//assert id was generated
		Assert.assertNotNull(address.getId());
		
		//get address
		Address addressAfterGet = addressService.getAddress(address.getId());
		Assert.assertNotNull(addressAfterGet);
	}

	
	@Test
	public void testUpdateAddressWithValidZipcode() throws InvalidZipcodeException{
		//create address
		Address address = new Address(null, "Avenida Paulista", "123", "01311000",  "São Paulo", "SP", "Bela Vista", "Loja 2");
		addressService.createAddress(address);
		
		//update address
		Address addressToUpdate = new Address(address.getId(), "Avenida Das Nações Unidas", "123", "01311000",  "São Paulo", "SP", "Interlagos", "Loja 2");
		boolean updated = addressService.updateAddress(addressToUpdate);
		Assert.assertTrue(updated);
		
		
		//get after update and check if fields were updated
		Address addressAfterUpdate = addressService.getAddress(address.getId());
		Assert.assertEquals(addressToUpdate.getId(), addressAfterUpdate.getId());
		Assert.assertEquals(addressToUpdate.getStreet(), addressAfterUpdate.getStreet());
		Assert.assertEquals(addressToUpdate.getNumber(), addressAfterUpdate.getNumber());
		Assert.assertEquals(addressToUpdate.getZipcode(), addressAfterUpdate.getZipcode());
		Assert.assertEquals(addressToUpdate.getCity(), addressAfterUpdate.getCity());
		Assert.assertEquals(addressToUpdate.getState(), addressAfterUpdate.getState());
		Assert.assertEquals(addressToUpdate.getDistrict(), addressAfterUpdate.getDistrict());
		Assert.assertEquals(addressToUpdate.getComplement(), addressAfterUpdate.getComplement());
	}
	
	
	@Test(expected=InvalidZipcodeException.class)
	public void testUpdateAddressWithInvalidZipcode() throws InvalidZipcodeException{
		//create address
		Address address = new Address(null, "Avenida Paulista", "123", "01311000",  "São Paulo", "SP", "Bela Vista", "Loja 2");
		addressService.createAddress(address);
		
		//update address
		Address addressToUpdate = new Address(address.getId(), "Avenida Das Nações Unidas", "123", "01411000",  "São Paulo", "SP", "Interlagos", "Loja 2");
		addressService.updateAddress(addressToUpdate);
	}
	
	
	@Test
	public void testUpdateAddressWhenIdDoesNotExist() throws InvalidZipcodeException{
		//update address
		Address addressToUpdate = new Address(999999999, "Avenida Das Nações Unidas", "123", "01311000",  "São Paulo", "SP", "Interlagos", "Loja 2");
		boolean updated = addressService.updateAddress(addressToUpdate);
		Assert.assertFalse(updated);
	}
	
	
	@Test
	public void testDeleteAddress() throws InvalidZipcodeException{
		//create address
		Address address = new Address(null, "Avenida Paulista", "123", "01311000",  "São Paulo", "SP", "Bela Vista", "Loja 2");
		addressService.createAddress(address);
		
		//delete address
		boolean deleted = addressService.deleteAddress(address.getId());
		Assert.assertTrue(deleted);
		
		//assert was deleted
		Assert.assertNull(addressService.getAddress(address.getId()));
	}
	
	
	@Test
	public void testDeleteAddressWhenIdDoesNotExist(){
		//delete address
		boolean deleted = addressService.deleteAddress(999999999);
		Assert.assertFalse(deleted);
	}
	
}
