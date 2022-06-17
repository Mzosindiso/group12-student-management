/*
    Shasta Abrahams - 217059376
    EmployeeService.java
    16 June 2022
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;
import za.ac.cput.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository repository;

    @Autowired public EmployeeServiceImpl(IEmployeeRepository repository){
        this.repository = repository;
    }
    @Override
    public Employee save (Employee employee){
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee>read(String staffId){
        return this.repository.findById(staffId);
    }

    @Override
    public void delete(Employee employee){

        this.repository.delete(employee);
    }
    @Override
    public List<Employee> findAll(){

        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Employee> employee = read(id);
        if(employee.isPresent())
            delete(employee.get());
    }

}
