package com.majid.Jdbc.Template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.majid.Jdbc.Template.DAO.DAO;
import com.majid.Jdbc.Template.controllers.City;

@SpringBootApplication()
public class JdbcTemplateApplication {
	private static DAO<City> dao;
	
	public JdbcTemplateApplication(DAO<City> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateApplication.class, args);
		
		System.out.println("All cities-----------------------");
		List<City> cities=dao.list();
			cities.forEach(System.out::print);
		City khp=new City();
		
		khp.setName("Khairpur");
		khp.setPopulation(300000);
		khp.setDistrict("Dist. Khairpur");
		
		dao.create(khp);
		
		System.out.println("All cities after created an other city-----------------------");
		cities=dao.list();
			cities.forEach(System.out::print);
			
			City jam=new City();
			
			jam.setName("Jamshoro");
			jam.setPopulation(300000);
			jam.setDistrict("Dist. Jamshoro");
			
			dao.create(jam);
			
			System.out.println("All cities after created an other city-----------------------");
			cities=dao.list();
				cities.forEach(System.out::print);
				
				System.out.println("Get city with a given id");
			var city3=dao.get(2);
			System.out.println(city3.get().getName());
			
			System.out.println("Update a given city ----------------------");
			
			jam.setDistrict("District jam.");
			dao.update(jam,4);
			
			System.out.println("After update city's District ");
			cities=dao.list();
			cities.forEach(System.out::print);
			
	
	}
}
