package com.student.Service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.student.Dao.EmployeeDao;
import com.student.Model.Employee;

@Service
public class EmployeeService {
	
	private static Logger logger=LoggerFactory.getLogger(EmployeeService.class);
	
	public static Map<Integer, EmployeeDao> map=new ConcurrentHashMap<Integer, EmployeeDao>();
	
	//@Fake Database.
	public static Map<Integer, EmployeeDao> DaoOperation() {
		map.put(1, new EmployeeDao(101, "Saurav Kumar", "9691098742", 45000.95));
		map.put(2, new EmployeeDao(102, "Rishav Jain", "8547412560", 14524.00));
		map.put(3, new EmployeeDao(103, "Manu Kumar", "9874510254", 22500.45));
		map.put(4, new EmployeeDao(104, "Sweta Bharti", "6587412560", 56454.25));
		map.put(5, new EmployeeDao(105, "Vivek Rai", "9874512030", 35666.85));
		map.put(6, new EmployeeDao(106, "Krishna Singh", "8547415230", 58600.85));
		map.put(7, new EmployeeDao(107, "Avinash Rajput", "9874512035", 69555.35));
		
		logger.info("--DaoOperation-- "+map);
		return map;
	}
	
	//@create new data.
	public static Map<Integer, EmployeeDao> createEmployeeDetails(int id, Employee employee) {
		Map<Integer, EmployeeDao> mapdata=DaoOperation();
		if(!mapdata.containsKey(id)) {
			map.put(id, new EmployeeDao(employee.getEmpid(), employee.getName(), employee.getMobno(), employee.getSalary()));
		}else {
			logger.info("--createEmployeeDetails Responce-- " + "Duplicate key present");
		}
		logger.info("--createEmployeeDetails Responce-- "+map);
		return map;
	}
	
	//@get all employee details.
	public static Map<Integer, EmployeeDao> getEmployeeDetails() {
		Map<Integer, EmployeeDao> getmap=DaoOperation();
		logger.info("--getEmployeeDetails-- "+getmap);
		return getmap;
	}
	
	//@get  employee details by id.
	public static List<Entry<Integer, EmployeeDao>> getEmployeeDetailsById(int id) {
		Map<Integer, EmployeeDao> getmap=DaoOperation();
		List<Entry<Integer, EmployeeDao>> emplist=getmap.entrySet().stream().filter(m->m.getKey()==id).collect(Collectors.toList());
		logger.info("--getEmployeeDetailsById-- "+emplist);
		return emplist;
	}
	
	//@update existing data.
	public static Map<Integer, EmployeeDao> updateEmployeeDetails(int id,Employee employee) {
		Map<Integer, EmployeeDao> empdataMap=DaoOperation();
		if(empdataMap.containsKey(id)) {
			map.put(id, new EmployeeDao(employee.getEmpid(), employee.getName(), employee.getMobno(), employee.getSalary()));
		}else {
			logger.info("--updateEmployeeDetails Responce-- " + "key Not Available");
		}
		logger.info("--updateEmployeeDetails Responce-- "+map);
		return map;
	}
	
	//@delete  a data.
	public static Map<Integer, EmployeeDao> deleteEmployeeDetails(int id) {
		Map<Integer, EmployeeDao> empdataMap=DaoOperation();
		if(empdataMap.containsKey(id)) {
			map.remove(id);
		}else {
			logger.info("--deleteEmployeeDetails Responce-- "+"Key not found");
		}
		logger.info("--deleteEmployeeDetails Responce-- "+map);
		return map;
	}
}
