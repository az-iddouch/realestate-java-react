package com.vash.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.CityVo;
import com.vash.service.ICityService;

@RestController
@RequestMapping(value="/api/city")
public class CityController {

	@Autowired
	private ICityService iCityService;

	@PostMapping(value = "/save")
	public ResponseEntity<Object> save(@RequestBody CityVo cityVo) {

		CityVo cityVop = iCityService.save(cityVo);
		if (ObjectUtils.isEmpty(cityVop)) {
			return new ResponseEntity<>("Error", HttpStatus.OK);
		}

		return new ResponseEntity<>("Yes", HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Object> findAll() {

		List<CityVo> cityVos = iCityService.findAll();
		if (ObjectUtils.isEmpty(cityVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}

		return new ResponseEntity<>(cityVos, HttpStatus.OK);
	}
	//findByNameCityIgnoreCaseContaining %...%
	@GetMapping(value = "/autocompilation")
	public ResponseEntity<Object> findByNameCityIgnoreCaseContaining(@PathVariable (value="nameCity") String namecity) {
		List<CityVo> cityVos =new ArrayList<CityVo>();
		cityVos = iCityService.findByNameCityIgnoreCaseContaining(namecity);
		if (ObjectUtils.isEmpty(cityVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(cityVos, HttpStatus.OK);
	}
// search by namecity return  CityVo
	@GetMapping(value = "/serachByNameCity")
	public ResponseEntity<Object> findByNameCityIgnore(@PathVariable (value="nameCity") String namecity) {
		CityVo cityVo  = iCityService.findByNameCityIgnoreCase(namecity);
		if (ObjectUtils.isEmpty(cityVo)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(cityVo, HttpStatus.OK);
	}
	
	@GetMapping(value = "/serachCityByNameCountry")
	public ResponseEntity<Object> findByCountryNameCountry(@PathVariable (value="nameCountry") String nameCountry) {
		List<CityVo> cityVos =new ArrayList<CityVo>();
		cityVos= iCityService.findByCountryNameCountry(nameCountry);
		if (ObjectUtils.isEmpty(cityVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(cityVos, HttpStatus.OK);
	}
	//countPropertyByCity
	@GetMapping(value = "/countPropertyByCity")
	public ResponseEntity<Object> countPropertyByCity(@PathVariable (value="nameCountry") String nameCountry) {
		Map<CityVo,Integer> maps=new HashMap<CityVo, Integer>();
		maps= iCityService.countPropertyByCity(nameCountry);
		if (ObjectUtils.isEmpty(maps)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(maps, HttpStatus.OK);
	}
	
}