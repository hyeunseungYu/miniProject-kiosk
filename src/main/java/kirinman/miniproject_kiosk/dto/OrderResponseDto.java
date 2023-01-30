package kirinman.miniproject_kiosk.dto;

import lombok.Getter;

@Getter
public class OrderResponseDto {
    private Integer totalAmount;

    public OrderResponseDto(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
