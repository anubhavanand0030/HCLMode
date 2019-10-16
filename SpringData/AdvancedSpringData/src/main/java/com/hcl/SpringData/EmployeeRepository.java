package com.hcl.SpringData;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employ,Integer> {
	@Query("Select e from Employ e where dept= ?1 and desig= ?2")
	List<Employ> findByDeptAndDesig(String department,String designation);
	@Query("Select e from Employ e where dept= ?1 and desig= ?2 and basic>50000")
	List<Employ> findByDeptAndDesigAndBasic(String department,String designation);
	@Query("select e from Employ e where basic<50000 and name  LIKE 'A%'")
	List<Employ> findBySalaryAndStartA();
	
	List<Employ> findByDeptAndDesig(String department,String designation,Sort sort);
	

}
