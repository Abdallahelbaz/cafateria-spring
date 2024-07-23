package edu.cafeteria.Services;
 

import edu.cafeteria.Repos.UserRepo;
import edu.cafeteria.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
 
	@Autowired
    private UserRepo userRepository;

    public boolean isStaffIDTaken(StaffID staffID) {
        return userRepository.existsByStaffID(staffID);
    }

    public boolean isEmployeeIDTaken(EmployeeID employeeID) {
        return userRepository.existsByEmployeeID(employeeID);
    }
	//
   
	
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
