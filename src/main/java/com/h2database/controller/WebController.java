package com.h2database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.h2database.model.Users;
import com.h2database.model.Room;
import com.h2database.repository.CustomerRepository;
import com.h2database.repository.RoomsRepository;

@RestController
public class WebController {
	@Autowired
	CustomerRepository CustRepository;
	@Autowired
	RoomsRepository RoomRepository;

	@RequestMapping("/api/createUser")
	public String process(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("city") String city, @RequestParam("address") String address,
			@RequestParam("contact") Long contact) {
		CustRepository.save(new Users(firstName, lastName, email, password, city, address, contact));
		return "Success";
	}

	@RequestMapping("/api/saveRoom")
	public String process() {
		 RoomRepository.save(new Room("Deluxe", "3", "12", "Deluxe.jpg", "Deluxe.jpg", "Deluxe.jpg", "Deluxe.jpg"));
		//CustRepository2.save(new Customer2(1,"firstName", "lastName", "email", "password", "city", "address", 333));
		return "Success";
	}

	@RequestMapping("/api/findall")
	public List<Users> findAllCustomers() {
		List<Users> result = (List<Users>) CustRepository.findAll();

		/*
		 * for(Customer cust : repository.findAll()){ // result += cust.toString() +
		 * "</br>";
		 * 
		 * }
		 */

		return result;
	}

	/*
	 * @RequestMapping("/api/findbyid") public Customer findById(@RequestParam("id")
	 * long id){ Customer result = new Customer(); result = repository.findOne(id);
	 * return result; }
	 * 
	 * @RequestMapping("/findbylastname") public String
	 * fetchDataByLastName(@RequestParam("lastname") String lastName){ String result
	 * = "";
	 * 
	 * for(Customer cust: repository.findByLastName(lastName)){ result +=
	 * cust.toString() + "</br>"; } return result; }
	 */

	@RequestMapping("/api/getUser")
	public Users fetchDataByLoginDetails(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		for (Users cust : CustRepository.findByEmail(email)) {
			if (cust.getPassword().contentEquals(password)) {
				return cust;
			}
		}
		return null;
	}

	@RequestMapping("/api/findsRooms")
	public List<Room> findAvailableRooms() {
		/*
		 * for(Rooms alailRooms: RoomRepository.availableRooms()) { return alailRooms; }
		 */
		List<Room> result = (List<Room>) RoomRepository.findAll();
		return result;
	}

	@RequestMapping("/api/findRooms")
	public List<Room> findAllRooms() {
		List<Room> result = (List<Room>) RoomRepository.findAll();
		return result;
	}
}
