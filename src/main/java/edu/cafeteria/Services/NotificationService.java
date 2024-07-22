package edu.cafeteria.Services;
import edu.cafeteria.Repos.NotificationRepository;
import edu.cafeteria.model.Notification;
import org.springframework.stereotype.Service; 
import org.springframework.beans.factory.annotation.Autowired; 

import java.util.List;
import java.util.Optional; 
@Service
public class NotificationService {

	
	

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id);
    }

    public Optional<List<Notification>> findByUserId(Long userId) {
        return  notificationRepository.findByUserId(userId);
    }
     
    public List<Notification> getNotificationsForUser(Long userId) {
       
    	return null;
    }

	public int countNotificationsByUserId(Long idd) {
		 return notificationRepository.countByUserId(idd);
	}
}