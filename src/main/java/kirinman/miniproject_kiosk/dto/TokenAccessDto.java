package kirinman.miniproject_kiosk.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenAccessDto {
    private String authorization;

    public TokenAccessDto(String authorization) {
        this.authorization = authorization;
    }
}
