package kirinman.miniproject_kiosk.dto.member;

import lombok.Getter;

@Getter
public class UpdatePointDto {
    private Integer point;

    public UpdatePointDto(Integer point) {
        this.point = point;
    }
}
