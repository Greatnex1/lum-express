package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
