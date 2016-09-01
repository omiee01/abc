package com.onlineshodh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlineshodh.entity.CityEntity;
import com.onlineshodh.entity.StateEntity;
import com.onlineshodh.service.CityService;
import com.onlineshodh.service.CountryService;
import com.onlineshodh.service.StateService;

@Controller
@RequestMapping(value="/admin/cities")
public class CityController {
	@Autowired
	StateService stateservice;
	@Autowired
	CountryService countryservice;
	@Autowired
	CityService cityservice;
	@RequestMapping(value={"","/"})
	public String showCity(ModelMap model,@ModelAttribute("cities") CityEntity city)
	{
		model.addAttribute("city", new CityEntity());
		model.addAttribute("countries",countryservice.showManageCountry());
		model.addAttribute("cities", cityservice.showAllCities());
		//model.addAttribute("states", stateservice.showAllStates());
		return "city/manageCity";
	}
	
	@RequestMapping(value = "/showstates", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<StateEntity> showStates(ModelMap model,
			@RequestParam("countryID") Integer countryId) {
		System.out.println("I am in show states"+countryId);
		List<StateEntity> states = cityservice.showStates(countryId);
		for (StateEntity state : states)
			System.out.println(" States :" + state.getStateName());
		/*states = stateService.getAllStates(countryData);
		for (StateEntity state : states)
			System.out.println(" States :" + state.getStateName());*/
		return states;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveCity(ModelMap model,@ModelAttribute("city") CityEntity city)
	{
		System.out.println("City in Controller"+city);
		int result=cityservice.saveCity(city);
		if(result!=0)
			System.out.println("city has been saved sucessfully"+result);
		else
			System.out.println("fail to save");
		return "redirect:/admin/cities";
	}
	@RequestMapping(value="/delete/{cityId}")
	public String deleteCity(ModelMap model,@PathVariable("cityId") Integer cityId)
	{
		cityservice.deleteCity(cityId);
		return "redirect:/admin/cities";
	}
	@RequestMapping(value="/edit/{cityId}")
	public String editCity(ModelMap model,@PathVariable("cityId") Integer cityId )
	{
		model.addAttribute("city", cityservice.editCity(cityId));
		
		return "city/updateCity";
	}
	
	@RequestMapping(value="/update")
	public String updateCity(ModelMap model,@ModelAttribute("city") CityEntity city)
	{
		System.out.println("ID="+city.getCityId());
		cityservice.updateCity(city);
		return "redirect:/admin/cities";
	}
}
