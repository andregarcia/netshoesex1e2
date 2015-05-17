package netshoes.ex1e2.repository;

import java.util.List;
import java.util.Map;

import netshoes.ex1e2.model.ZipcodeAddress;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


@Repository
public class ZipcodeRepository {

	
	//mocked addresses (should use mockito instead?)
	private static Map<String, ZipcodeAddress> zipcodeAddresses;

	static{
		zipcodeAddresses = Maps.newHashMap();
		
		//create mocked zipcode addresses
		List<ZipcodeAddress> zipcodeAddressesList = Lists.newArrayList(
				new ZipcodeAddress("01311000", "Avenida Paulista", "Bela Vista", "S�o Paulo", "SP"),
				new ZipcodeAddress("05426200", "Avenida Brigadeiro Faria Lima", "Pinheiros", "S�o Paulo", "SP"),
				new ZipcodeAddress("05402000", "Avenida Rebou�as", "Pinheiros", "S�o Paulo", "SP"),
				new ZipcodeAddress("04013040", "Rua Cubat�o", "Vila Mariana", "S�o Paulo", "SP"),
				new ZipcodeAddress("01418000", "Alameda Santos", "Cerqueira Cesar", "S�o Paulo", "SP")
				);
		
		//populate mocked zipcode addresses
		for(ZipcodeAddress a : zipcodeAddressesList){
			zipcodeAddresses.put(a.getZipcode(), a);
		}
	}
	
	
	
	
	//get zipcode address
	public ZipcodeAddress getZipcodeAddress(String zipcode){
		return zipcodeAddresses.get(zipcode);
	}
	
	
	
}
