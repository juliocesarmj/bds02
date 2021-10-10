package com.devsuperior.bds02.resource.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.city.ICityService;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {
	
	@Autowired
	private ICityService service;
	
	@GetMapping
	public ResponseEntity<List<CityDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.getAllSortedByName());
	}
	
	@PostMapping
	public ResponseEntity<CityDTO> post(@RequestBody CityDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.insert(dto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.service.delete(id));
	}

}
