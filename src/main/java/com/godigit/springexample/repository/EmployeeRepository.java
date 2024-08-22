package com.godigit.springexample.repository;

import com.godigit.springexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//CROS
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employee_table e, department_table d where e.emp_id = d.employee_id and department=:dept;",nativeQuery = true)
    List<Employee> findEmployeeByDepartment(String dept);

    Employee findByName(String name);
}
