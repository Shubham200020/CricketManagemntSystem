package com.example.demo.REPOSITORY.location;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.POJO.location.City;
import com.example.demo.POJO.location.State;
@Repository
public interface StateRepo extends JpaRepository<State, String>{
	@Query(value = "select c from State s inner join s.city c  where s.stateid=?1 order by c.cotyname")
	List<City> displayByState(String s);
	@Query(value = "select s from State s order by s.statename")
	List<State> orderState();
	
	@Query(value = "delete  from State s")
	public void deleteAllData(); 
	//@Modifying
	//@Query(value = "update State s set s.city =:city where s.stateid =:stateid")
	//public State updateCity(@PathVariable("city") List<City> city,@PathVariable("stateid") String stateid);
}
