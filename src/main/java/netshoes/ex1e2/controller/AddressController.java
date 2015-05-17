package netshoes.ex1e2.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import netshoes.ex1e2.exception.InvalidZipcodeException;
import netshoes.ex1e2.model.Address;
import netshoes.ex1e2.service.AddressService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AddressController {

	
	@Inject
	private AddressService addressService;
	
	
	@RequestMapping(value="/address/{id}", method=RequestMethod.GET)
	public ResponseEntity<Address> getAddress(@PathVariable(value="id") Integer id){
		Address address = addressService.getAddress(id);
		if(address==null){
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/address/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAddress(@PathVariable(value="id") Integer id){
		boolean deleted = addressService.deleteAddress(id);
		if(!deleted){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value="/address", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateAddress(@RequestBody @Valid Address address) throws InvalidZipcodeException{
		boolean updated = addressService.updateAddress(address);
		if(!updated){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value="/address", method=RequestMethod.POST)
	public ResponseEntity<Address> createAddress(@RequestBody @Valid Address address) throws InvalidZipcodeException{
		Address result = addressService.createAddress(address);
		return new ResponseEntity<Address>(result, HttpStatus.CREATED);
	}
	
	
	
}
