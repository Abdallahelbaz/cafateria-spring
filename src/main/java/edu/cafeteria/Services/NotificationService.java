package edu.cafeteria.Services;
import edu.cafeteria.Repos.NotificationRepository;
import edu.cafeteria.model.Notification;
import org.springframework.stereotype.Service;
import edu.cafeteria.model.Notification;
import edu.cafeteria.Repos.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.List;
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
    // Simulated fetching notifications logic
    public List<Notification> getNotificationsForUser(Long userId) {
        // Implement fetching notifications from database or other source
      //  return List.of(new Notification(1L, userId, "Order is ready"));
    	return null;
    }

	public int countNotificationsByUserId(Long idd) {
		 return notificationRepository.countByUserId(idd);
	}
}