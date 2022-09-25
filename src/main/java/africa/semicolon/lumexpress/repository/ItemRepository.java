package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
