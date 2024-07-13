package com.example.demo.Controller.location;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.POJO.location.City;
import com.example.demo.POJO.location.State;
import com.example.demo.POJO.players.Role;
import com.example.demo.REPOSITORY.location.CityRepo;
import com.example.demo.REPOSITORY.location.StateRepo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@RestController
@RequestMapping("/location")
@CrossOrigin("http://localhost:4200")
public class Location {
	
	@Autowired
	StateRepo staterepo;
	@Autowired
	CityRepo cityRepo;
	//Show States
	
	int i=0;
	public int setData() {
		
		return i;
	}
	@GetMapping("/show-data")
	public List<State> showState()
	{
		List<State> st;
		st=staterepo.orderState();
		
		return st;
	}
	 @GetMapping("/set-cookie/{id}")
	    public String setCookie(HttpServletResponse response,@PathVariable String id) {
	        Cookie cookie = new Cookie("cookieName", id);
	        cookie.setMaxAge(7 * 24 * 60 * 60); // 1 week
	        cookie.setSecure(true); // only if using HTTPS
	        cookie.setHttpOnly(true); // accessible only via HTTP(S), not JavaScript
	        cookie.setPath("/"); // available to the entire application
	       // cookie.setSameSite("Strict");
	        response.addCookie(cookie);
	        return "Login Sucessfully";
	    }
	 @GetMapping("/get-cookie/{cookieName}")
	    public String getCookie(HttpServletRequest request, @PathVariable String cookieName) {
	        Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            Optional<Cookie> cookie = Arrays.stream(cookies)
	                                            .filter(c -> cookieName.equals(c.getName()))
	                                            .findFirst();
	            if (cookie.isPresent()) {
	                String data= cookie.get().getValue();
	                if(data!="")
	                {
	                	return data;
	                }
	                else 
	                	return "Hello1";
	            }
	        }
	        return "Hello";
	    }

	    @GetMapping("/delete-cookie")
	    public String deleteCookie(HttpServletResponse response) {
	        Cookie cookie = new Cookie("cookieName", null);
	        cookie.setMaxAge(0);
	        cookie.setPath("/");
	        response.addCookie(cookie);
	        return "Cookie deleted";
	    }
	
	//Insert City State By Id
	@PostMapping("/update-city/{id}")
	public State showcity(@RequestBody City city,@PathVariable String id)
	{
		State ob=	staterepo.findById(id).get();
		String cityname=city.getCotyname().toLowerCase();
		city.setCotyname(cityname);
		List<City>cit=ob.getCity();
		cit.add(city);
		ob.setCity(cit);
		ob=staterepo.save(ob);
		
		return ob;
	}
	//insert State
	@PostMapping("/insert-data")
	public State addData(@RequestBody State state) {
		String dat=state.getStatename();
		dat=dat.toLowerCase();
		System.out.println(dat);
		state.setStatename(dat);
		staterepo.save(state);
		return state;
	}
	
	//Display all City
	@GetMapping("display-city")
	public List<City> dis(){
		List<City> cities=cityRepo.orderCityName();
		return cities;
	}
	
	
	//display city by state id
	@GetMapping("/display-by-stateid/{id}")
	public List<City> displayByStateid(@PathVariable String id){
		List<City> ct=staterepo.displayByState(id);
		return ct;
	}
	
	
	//Delete All State
	@GetMapping("/delete-all-state")
	public List<City> deleteSity(){
		staterepo.deleteAll();
		return null;
	}
	
	//delete All City
	@GetMapping("/delete-all-city")
	public List<City> deleteCity(){
		cityRepo.deleteAll();
		return null;
	}
	@GetMapping("/role")
	public Role[] getRole() {
		
		return Role.values();
	}
	//delete city by id
	@GetMapping("/delete-by-id/{id}")
	public City deleteByIdCity(@PathVariable String id){
		cityRepo.deleteById(id);
		return null;
	}
}
