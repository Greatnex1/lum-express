package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.service.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}