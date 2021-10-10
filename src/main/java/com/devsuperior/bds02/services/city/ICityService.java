package com.devsuperior.bds02.services.city;

import java.util.List;

import com.devsuperior.bds02.dto.CityDTO;

public interface ICityService {

	List<CityDTO> getAllSortedByName();

	CityDTO insert(CityDTO dto);

	Boolean delete(Long id);
}
