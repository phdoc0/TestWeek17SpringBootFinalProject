package com.promineotech.dealerships.dao;

import org.springframework.stereotype.Service;

@Service
public class VehicleDao {
    private static final String HOSTNAME = "jdbc:mysql://localhost:3306/dealership?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Dolphins";

    public void updateVehicle(int vehicleID, boolean b) {
    }
    
}
