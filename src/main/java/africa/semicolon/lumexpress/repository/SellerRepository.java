package africa.semicolon.lumexpress.repository;

import africa.semicolon.lumexpress.data.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
