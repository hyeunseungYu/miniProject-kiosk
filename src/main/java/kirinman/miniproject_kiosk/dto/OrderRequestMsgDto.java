package kirinman.miniproject_kiosk.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestMsgDto {
    private String msg;
    private Integer httpStatus;

    public OrderRequestMsgDto(String msg, Integer httpStatus) {
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
}
