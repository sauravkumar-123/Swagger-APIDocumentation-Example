package com.student.Controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Dao.EmployeeDao;
import com.student.Model.Employee;
import com.student.Service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "EmployeeController" ,description = "This is Employee Controller for Basic CRUD Operation")
@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

	private static Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value = "Save a employee",tags = "")
	@PostMapping("/create-employee/{id}")
	public ResponseEntity<Object> saveEmployeeData(@PathVariable("id") int id, @RequestBody Employee employee){
		Map<Integer, EmployeeDao> empdataMap=this.employeeService.createEmployeeDetails(id, employee);
	    return new ResponseEntity<Object>(empdataMap,HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Get the list of all employee",tags = "")
	@GetMapping("/get-employee")
	public ResponseEntity<Object> getEmployeeData(){
		Map<Integer, EmployeeDao> empdataMap=this.employeeService.getEmployeeDetails();
	    return new ResponseEntity<Object>(empdataMap,HttpStatus.OK);
		
	}
	
	@GetMapping("/get-employee-by-id/{id}")
	public ResponseEntity<Object> getEmployeeDataByid(@PathVariable("id") int id){
		List<Entry<Integer, EmployeeDao>> empdataList=this.employeeService.getEmployeeDetailsById(id);
	    return new ResponseEntity<Object>(empdataList,HttpStatus.OK);
		
	}
	
	@PutMapping("/update-employee-by-id/{id}")
	public ResponseEntity<Object> updateEmployeeDataByid(@PathVariable("id") int id, @RequestBody Employee employee){
		Map<Integer, EmployeeDao> empdataMap=this.employeeService.updateEmployeeDetails(id,employee);
	    return new ResponseEntity<Object>(empdataMap,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete-employee-by-id/{id}")
	public ResponseEntity<Object> deleteEmployeeDataByid(@PathVariable("id") int id){
		Map<Integer, EmployeeDao> empdataMap=this.employeeService.deleteEmployeeDetails(id);
	    return new ResponseEntity<Object>(empdataMap,HttpStatus.OK);
		
	}
}
