package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.data.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
}
