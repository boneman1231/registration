package org.redcenter.dao;

import java.util.List;

import org.redcenter.entity.Record;
import org.redcenter.entity.Target;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;

@RepositoryRestResource(collectionResourceRel = "records", path = "records")
public interface RecordRepository extends
		PagingAndSortingRepository<Record, Long> {

	List<Record> findByDate(@Param("date") String date);

	List<Record> findByDateBetween(
			@Param("from") @DateTimeFormat(iso = ISO.DATE) Date from,
			@Param("to") @DateTimeFormat(iso = ISO.DATE) Date to);

}