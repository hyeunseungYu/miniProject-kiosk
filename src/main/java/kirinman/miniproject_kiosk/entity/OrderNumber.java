package kirinman.miniproject_kiosk.entity;


import kirinman.miniproject_kiosk.dto.OrderNumberRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class OrderNumber extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderCnt = 0L;

    public OrderNumber(OrderNumberRequestDto orderNumberRequestDto) {
        this.orderCnt = orderNumberRequestDto.getOrderCnt();

    }
}
