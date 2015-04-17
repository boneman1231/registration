package org.redcenter.dao;

import java.util.List;

import org.redcenter.entity.Target;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "targets", path = "targets")
public interface TargetRepository extends PagingAndSortingRepository<Target, Long> {

	List<Target> findByName(@Param("name") String name);

}