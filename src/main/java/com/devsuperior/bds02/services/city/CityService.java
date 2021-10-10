package com.devsuperior.bds02.services.city;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.exceptions.city.CityDatabaseException;
import com.devsuperior.bds02.exceptions.city.CityException;
import com.devsuperior.bds02.repositories.city.ICityRepository;

@Service
public class CityService implements ICityService {

	@Autowired
	private ICityRepository repository;

	private static final String MSG_INTERNAL_SERVER_ERROR = "Internal error identified. Contact support";
	private static final String MSG_NOT_FOUND = "Object not found.";
	private static final String MSG_DATABASE_VIOLATION = "Database integrity violation.";
	
	@Transactional(readOnly = true)
	@Override
	public List<CityDTO> getAllSortedByName() {

		try {
			return this.repository.findAll().stream().map(CityDTO::new)
					.sorted((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new CityException(HttpStatus.INTERNAL_SERVER_ERROR, MSG_INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@Override
	public CityDTO insert(CityDTO dto) {

		try {

			City entity = new City();

			entity.setName(dto.getName());

			this.repository.save(entity);

			return new CityDTO(entity);
		} catch (Exception e) {
			throw new CityException(HttpStatus.INTERNAL_SERVER_ERROR, MSG_INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Boolean delete(Long id) {

		try {
			Optional<City> result = this.repository.findById(id);

			if (result.isPresent()) {
				this.repository.delete(result.get());
				return Boolean.TRUE;
			}
			throw new CityException(HttpStatus.NOT_FOUND, MSG_NOT_FOUND);

		} catch (CityException c) {
			throw c;
		} catch (DataIntegrityViolationException d) {
			throw new CityDatabaseException(HttpStatus.BAD_REQUEST, MSG_DATABASE_VIOLATION);
		} catch (Exception e) {
			throw new CityException(HttpStatus.INTERNAL_SERVER_ERROR, MSG_INTERNAL_SERVER_ERROR);
		}

	}

}
