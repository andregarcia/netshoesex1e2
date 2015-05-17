package netshoes.ex1e2.repository;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import netshoes.ex1e2.model.Address;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;




@Repository
public class AddressRepository {
	
	//in memory list of addresses
	private static Map<Integer, Address> addressById;
	
	private static AtomicInteger idGenerator;
	
	static{
		addressById = Maps.newHashMap();
		idGenerator = new AtomicInteger(0);
	}
	
	
	public Address createAddress(Address address){
		address.setId(idGenerator.incrementAndGet());
		addressById.put(address.getId(), address);
		return address;
	}
	
	public Address getAddress(Integer id){
		return addressById.get(id);
	}

	public boolean updateAddress(Address address){
		if(addressById.containsKey(address.getId())){
			addressById.put(address.getId(), address);
			return true;
		}
		return false;
	}
	
	public boolean deleteAddress(Integer id){
		if(addressById.containsKey(id)){
			addressById.remove(id);
			return true;
		}
		return false;
	}
	
	
}
