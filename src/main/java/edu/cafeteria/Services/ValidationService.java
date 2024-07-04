package edu.cafeteria.Services;
 

import edu.cafeteria.model.*; 
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidEmployeeID(String employeeID) {
        try {
            EmployeeID.valueOf(employeeID);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean isValidStaffID(String staffID) {
        try {
            StaffID.valueOf(staffID);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
