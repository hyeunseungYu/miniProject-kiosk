package kirinman.miniproject_kiosk.repository;


import kirinman.miniproject_kiosk.entity.OrderNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderNumberRepository extends JpaRepository<OrderNumber, Long> {

    Long countBy();
}