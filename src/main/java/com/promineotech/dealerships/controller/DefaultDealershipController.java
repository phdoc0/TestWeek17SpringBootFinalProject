package com.promineotech.dealerships.controller;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Employee;
import com.promineotech.dealerships.entity.Location;
import com.promineotech.dealerships.entity.Transaction;
import com.promineotech.dealerships.service.DealershipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDealershipController implements DealershipController{
    
    @Autowired
    private DealershipService dealershipService;

    
    //==========================Customers===============================================

    @Override
    @GetMapping("Customers")
    public ResponseEntity<List<Customer>> listCustomers(){
        log.info("customer list requested");
        List<Customer> customers = dealershipService.listCustomers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
    
    // Insert operation on customers table
    @Override
    public void newCustomer(int customerID, String name, String address, String phone){
        dealershipService.newCustomer(customerID, name, address, phone);
    }

    public void updateCustomer(int customerID, String name, String address, String phone){
        dealershipService.updateCustomer(customerID, name, address, phone);
    }

    // Delete operation on customers table
    public void deleteCustomer(int customerID, String name, String address, String phone){
        dealershipService.deleteCustomer(customerID, name, address, phone);
    }
    

  //==========================Transactions===============================================

    @Override
    public ResponseEntity<List<Transaction>> getTransactions(int transactionID) {
        List<Transaction> transactions = dealershipService.getTransactions(transactionID);
        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
        
    }
    @Override
    public void deleteTransaction(int transactionID) {
        dealershipService.deleteTransaction(transactionID);
        
    }

    @Override
    public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeID, int locationID,
            String date) {
        dealershipService.updateTransaction(transactionID, vehicleID, customerID, employeeID, locationID, date);
        
    }

    @Override
    public void newTransaction(int vehicleID, int customerID, int employeeID, int locationID, String date) {
       dealershipService.newTransaction(vehicleID, customerID, employeeID, locationID, date);
        
    }
    
  //==========================Locations===============================================
    @Override
    public ResponseEntity<List<Location>> getLocation(int locationID) {
        List<Location> location = dealershipService.getLocation(locationID);
        return new ResponseEntity<List<Location>>(location, HttpStatus.OK);
    }

    @Override
    public void deleteLocation(int locationID) {
        dealershipService.deleteTransaction(locationID);
        
    }

    @Override
    public void updateLocation(int locationID,
            String locationName) {
        dealershipService.updateLocation(locationID, locationName);
        
    }

    @Override
    public void newLocation(int locationID, String locationName) {
       dealershipService.newLocation(locationID, locationName);
        
    }
    
    //==========================Employees===============================================

    @Override
    @GetMapping("Employees")
    public ResponseEntity<List<Employee>> listEmployees(){
        log.info("employee list requested");
        List<Employee> employees = dealershipService.listEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }
    
   //@Override
    public void newEmployee(int employeeID, String name, int dealershipID){
        dealershipService.newEmployee(employeeID, name, dealershipID);
    }

    public void updateEmployee(int employeeID, String name, int dealershipID){
        dealershipService.updateEmployee(employeeID, name, dealershipID);
    }

  
    public void deleteEmployee(int employeeID, String name, int dealershipID){
        dealershipService.deleteEmployee(employeeID, name, dealershipID);
    }

}
