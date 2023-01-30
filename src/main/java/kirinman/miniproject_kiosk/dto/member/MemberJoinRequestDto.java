package kirinman.miniproject_kiosk.dto.member;

import lombok.Getter;

@Getter
public class MemberJoinRequestDto {
    private String phoneNumber;

    private Integer point=0;

    private Boolean smsAgreement;
}
