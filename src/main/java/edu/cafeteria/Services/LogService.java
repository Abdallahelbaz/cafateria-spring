package edu.cafeteria.Services;

import edu.cafeteria.model.Log;
import edu.cafeteria.Repos.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public void log(String user, String action, String role) {
        Log logEntry = new Log(new Date(), user, action,role);
        logRepository.save(logEntry);
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

	public Optional <List<Log>> getEMPlogs() {
		// TODO Auto-generated method stub
		return logRepository.getEMPlogs("employee");
	}

	public Optional <List<Log>> getGuestLogs() {
		// TODO Auto-generated method stub
		return logRepository.getGuestLogs("guest");
	}
	public Optional <List<Log>> getStaffLogs() {
		// TODO Auto-generated method stub
		return logRepository.getStaffLogs("staff");
	}
}
