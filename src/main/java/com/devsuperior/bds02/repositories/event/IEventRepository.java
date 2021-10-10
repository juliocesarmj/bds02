package com.devsuperior.bds02.repositories.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.bds02.entities.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {

}
