package kirinman.miniproject_kiosk.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderNumberRequestDto {
    private Long orderCnt = 0L;


    public OrderNumberRequestDto(Long orderCnt) {
        this.orderCnt = orderCnt;
    }
}
