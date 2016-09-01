package com.onlineshodh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshodh.dao.CityDao;
import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.StateEntity;

@Repository
public class CityDaoImpl implements CityDao {
	@Autowired
	SessionFactory sessionfactory;
	@Autowired
	CityEntity cityentity;
	
	public Integer saveCity(CityEntity city) {
		System.out.println("I am in saveCityDaoImpl----"+city+"----");
		Integer result=(Integer)sessionfactory.getCurrentSession().save(city);
		return result;
	}
	public List<StateEntity> showStates(Integer countryId) {
		System.out.println("i am in cityDaoImpl");
		String hql = "from StateEntity state where state.country.countryId = :countryId";
		Query query= sessionfactory.openSession().createQuery(hql);
		System.out.println("CountryId in Daoimpl= "+countryId);
		query.setInteger("countryId", countryId);
		List<StateEntity> states =(List<StateEntity>) query.list();
		System.out.println("States size: "+states.size());
		return states;
	}
	public List<CityEntity> showAllCities() {
		String hql="from CityEntity";
		Query query=sessionfactory.openSession().createQuery(hql);
		List<CityEntity> cities =query.list();
		System.out.println("Cities = "+cities);
		
		return cities;
	}
	public void deleteCity(Integer cityId) {
		System.out.println("cityId:"+cityId);
		 cityentity=(CityEntity)sessionfactory.openSession().get(CityEntity.class, cityId);
		System.out.println("In CityDaoImpl="+cityentity);
		sessionfactory.getCurrentSession().delete(cityentity);
		
	}
	public CityEntity editCity(Integer cityId) {
		CityEntity city=(CityEntity)sessionfactory.openSession().get(CityEntity.class, cityId);
		return city;
	}
	public void updateCity(CityEntity city) {
		System.out.println("ID="+city.getCityId());
		cityentity =(CityEntity)sessionfactory.openSession().get(CityEntity.class, city.getCityId());
		cityentity.setCityName(city.getCityName());
		cityentity.getState().setStateName(city.getState().getStateName());
		cityentity.getState().getCountry().setCountryName(city.getState().getCountry().getCountryName());
		sessionfactory.getCurrentSession().update(cityentity);
	}

	

}
