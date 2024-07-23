package edu.cafeteria.Services;

import edu.cafeteria.model.Log;
import edu.cafeteria.Repos.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

 

@Service
public class LogService {
    private static final Logger logger = LogManager.getLogger(LogService.class);

    @Autowired
    private LogRepository logRepository;

    public void log(String user, String action, String role) {
        Log logEntry = new Log(new Date(), user, action, role);
        logRepository.save(logEntry);

        
        logger.info("User: {}, Role: {}, Action: {}", user, role, action);
        logger.warn("-------Log4J----------");
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public Optional<List<Log>> getEMPlogs() {
        return logRepository.getEMPlogs("employee");
    }

    public Optional<List<Log>> getGuestLogs() {
        return logRepository.getGuestLogs("guest");
    }

    public Optional<List<Log>> getStaffLogs() {
        return logRepository.getStaffLogs("staff");
    }
}
