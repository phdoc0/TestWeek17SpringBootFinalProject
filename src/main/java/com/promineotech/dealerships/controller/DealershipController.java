package com.promineotech.dealerships.controller;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Employee;
import com.promineotech.dealerships.entity.Location;
import com.promineotech.dealerships.entity.Transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/Dealerships")
public interface DealershipController {
    
    //==========================Customers===============================================

    /**
     * Customer Handlers
     * @return
     */
    @GetMapping("Customers")
    ResponseEntity<List<Customer>> listCustomers();
    
    // Insert customer
    @PostMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void newCustomer(
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String address, 
        @RequestParam(required = false) String phone);

    @PutMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void updateCustomer(
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String address, 
        @RequestParam(required = false) String phone);


    // Delete operation on customers table
    @DeleteMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteCustomer(
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String address, 
        @RequestParam(required = false) String phone);

    //==========================Transactions===============================================

    /**
     * Transaction handlers 
     * @param transactionID
     * @return
     */
    @GetMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<Transaction>> getTransactions(
        @RequestParam(required = true) int transactionID
    );

    @DeleteMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteTransaction(
        @RequestParam(required = true) int transactionID
    );

    @PostMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void newTransaction( 
        @RequestParam(required = true) int vehicleID, 
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = true) int employeeID, 
        @RequestParam(required = true) int locationID, 
        @RequestParam(required = true) String date);

    @PutMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void updateTransaction(
        @RequestParam(required = true) int transactionID, 
        @RequestParam(required = false) int vehicleID, 
        @RequestParam(required = false) int customerID, 
        @RequestParam(required = false) int employeeID, 
        @RequestParam(required = false) int locationID, 
        @RequestParam(required = false) String date);


//==========================Locations===============================================

/**
 * Location handlers 
 * @param locationID
 * @return
 */
@GetMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
ResponseEntity<List<Location>> getLocation(
    @RequestParam(required = true) int locationID
);

@DeleteMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void deleteLocation(
    @RequestParam(required = true) int locationID
);

@PostMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void newLocation( 
    @RequestParam(required = true) int locationID, 
    @RequestParam(required = true) String locationName);

@PutMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void updateLocation(
    @RequestParam(required = false) int locationID, 
    @RequestParam(required = false) String locationName);

//==========================Employee===============================================


@GetMapping("Employees")
ResponseEntity<List<Employee>> listEmployees();


@PostMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void newEmployee(
    @RequestParam(required = true) int employeeID, 
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String dealershipID);
   

@PutMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void updateEmployee(
    @RequestParam(required = true) int employeeID, 
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String dealershipID);


@DeleteMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void deleteEmployee(
    @RequestParam(required = true) int employeeID, 
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String dealershipID);





}// end DealershipController Interface

