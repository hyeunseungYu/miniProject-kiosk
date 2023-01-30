package kirinman.miniproject_kiosk.repository;


import kirinman.miniproject_kiosk.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByCreatedAt(String time);

    List<Orders> findAllByCreatedAtContains(String date);


}
