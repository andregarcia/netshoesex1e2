package netshoes.ex1e2.service;

import java.util.regex.Pattern;

import javax.inject.Inject;

import netshoes.ex1e2.model.ZipcodeAddress;
import netshoes.ex1e2.repository.ZipcodeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class ZipcodeService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZipcodeService.class);
	
	@Inject
	private ZipcodeRepository zipcodeRepository;
	
	
	public ZipcodeAddress getZipcodeAddress(String zipcode){
		LOGGER.info("Fetching zipcodeAddress, zipcode=" + zipcode);
		ZipcodeAddress result = null;
		
		for(int i=zipcode.length()-1; i>=0; i--){
			result = zipcodeRepository.getZipcodeAddress(zipcode);
			if(result!=null){
				break;
			}
			zipcode = replaceCharInPositionByZero(zipcode, i);
		}
		return result;
	}
	
	
	public boolean isZipcodeValid(String zipcode){
		Pattern p = Pattern.compile("[0-9]{8}");
		return p.matcher(zipcode).matches();
	}
	
	
	public String replaceCharInPositionByZero(String zipcode, int position){
		zipcode = zipcode.substring(0, position) + "0" + zipcode.substring(position+1, zipcode.length());
		return zipcode;
	}
	
	
}
