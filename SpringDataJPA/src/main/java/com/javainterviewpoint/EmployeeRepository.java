package com.javainterviewpoint;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	@Query("select distinct e from Employee e  join fetch e.employeeAddress ea where ea.country = :country")
	List<Employee> findByCountry(@Param("country")String country);
	
	@Query("select distinct e from Employee e  join fetch e.employeeAddress ea where ea.country = :country order by ea.state Desc")
	List<Employee> findByCountrySortBy(@Param("country")String country);
}
