package kirinman.miniproject_kiosk.dto;


import lombok.Getter;

@Getter
public class StackPointResponseDto {
    private Integer points;

    public StackPointResponseDto(Integer points) {
        this.points = points;
    }
}
