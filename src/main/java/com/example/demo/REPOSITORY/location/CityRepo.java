package com.example.demo.REPOSITORY.location;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.POJO.location.City;




public interface CityRepo extends JpaRepository<City, String>{
	@Query(value = "select c from City c order by c.cotyname")
	public List<City> orderCityName();
	@Query(value = "delete  from City c")
	public void deleteAllData(); 
	

}
