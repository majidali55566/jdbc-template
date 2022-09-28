package com.majid.Jdbc.Template.DAO;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.majid.Jdbc.Template.controllers.City;


@Component
public class CityJdbcDao implements DAO<City> {
	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(CityJdbcDao.class);
	private JdbcTemplate jdbcTemplate;
	
	    private RowMapper<City> rowMapper=(rs,rowNo) -> {
		City city=new City();
		city.setId(rs.getInt("id"));
		city.setName(rs.getString("name"));
		city.setPopulation(rs.getInt("population"));
		city.setDistrict(rs.getString("district"));
		return city;
		};

	@Autowired
	public CityJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<City> list() {
		String sql="Select id, name, population, district from city";
		return jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public void create(City t) {
		String sql ="Insert into city(name,population,district) values(?,?,?)";
		int rowsEffected=jdbcTemplate.update(sql,t.getName(),t.getPopulation(),t.getDistrict());
		if(rowsEffected==1) {
			logger.info("New City Added created :"+t.getName());
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<City> get(int id) {
		String sql="Select * from city where id=?";
		City city=null;
		try {
		 city=jdbcTemplate.queryForObject(sql, new Object[] {id},rowMapper);
		}catch(DataAccessException ex) {
			logger.info("Could not found city with given id "+id);
		}
		return Optional.ofNullable(city);
	}
		

	@Override
	public void update(City t, int city_id) {
		String sql="update city(name,population,district) set name=?, population=?, district=? where id=?";
		int rowEffected=jdbcTemplate.update(sql, t.getName(),t.getPopulation(),t.getDistrict());
		
		if(rowEffected==1) {
			logger.info("city updated with id :"+city_id);
		}
		
	}

	
}
