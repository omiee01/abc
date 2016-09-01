package com.onlineshodh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="city")
public class CityEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2851080835500309403L;
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="cityid")
	private Integer cityId;
	
	@Column(name="cityname")
	private String cityName;
	
	@ManyToOne(targetEntity=StateEntity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="stateId")
	StateEntity state;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public StateEntity getState() {
		return state;
	}
	public void setState(StateEntity state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CityEntity [cityId=" + cityId + ", cityName=" + cityName
				+ ", state=" + state + "]";
	}
	
}
