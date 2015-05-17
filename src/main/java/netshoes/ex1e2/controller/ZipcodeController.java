package netshoes.ex1e2.controller;

import javax.inject.Inject;

import netshoes.ex1e2.exception.InvalidZipcodeException;
import netshoes.ex1e2.model.ZipcodeAddress;
import netshoes.ex1e2.service.ZipcodeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ZipcodeController {

	
	@Inject
	private ZipcodeService zipcodeService;
	
	
	
	@ResponseBody
	@RequestMapping(value="/zipcode/{zipcode}", method=RequestMethod.GET)
	public ResponseEntity<ZipcodeAddress> getZipcodeAddressByZipcode(@PathVariable(value="zipcode") String zipcode) throws InvalidZipcodeException{
		if(!zipcodeService.isZipcodeValid(zipcode)){
			throw new InvalidZipcodeException("CEP Invalido");
		}
		
		ZipcodeAddress result = zipcodeService.getZipcodeAddress(zipcode);
		
		if(result==null){
			return new ResponseEntity<ZipcodeAddress>(HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<ZipcodeAddress>(result, HttpStatus.OK);
		}
		
	}
	
	
}
