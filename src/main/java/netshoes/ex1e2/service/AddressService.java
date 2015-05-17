package netshoes.ex1e2.service;

import javax.inject.Inject;

import netshoes.ex1e2.exception.InvalidZipcodeException;
import netshoes.ex1e2.model.Address;
import netshoes.ex1e2.repository.AddressRepository;
import netshoes.ex1e2.repository.ZipcodeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class AddressService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);
	
	
	@Inject
	private AddressRepository addressRepository;
	
	@Inject
	private ZipcodeRepository zipcodeRepository;
	
	
	public Address createAddress(Address address) throws InvalidZipcodeException {
		LOGGER.info("Creating address " + address);
		if(zipcodeRepository.getZipcodeAddress(address.getZipcode())==null){
			throw new InvalidZipcodeException("CEP Invalido");
		}
		return addressRepository.createAddress(address);
	}
	
	
	public Address getAddress(Integer id){
		LOGGER.info("Fetching address id=" + id);
		return addressRepository.getAddress(id);
	}

	
	public boolean updateAddress(Address address) throws InvalidZipcodeException {
		LOGGER.info("Updating address " + address);
		if(zipcodeRepository.getZipcodeAddress(address.getZipcode())==null){
			throw new InvalidZipcodeException("CEP Invalido");
		}
		return addressRepository.updateAddress(address);
	}
	
	
	public boolean deleteAddress(Integer id){
		LOGGER.info("Deleting address id=" + id);
		return addressRepository.deleteAddress(id);
	}
	
	
}
