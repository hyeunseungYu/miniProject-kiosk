package kirinman.miniproject_kiosk.entity;


import kirinman.miniproject_kiosk.dto.member.MemberJoinRequestDto;
import kirinman.miniproject_kiosk.dto.member.UpdatePointDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false)
    private Boolean smsAgreement;

    @Enumerated(value = EnumType.STRING)
    private MemberRoleEnum role;

    public Member(MemberJoinRequestDto requestDto, MemberRoleEnum role){
        this.phoneNumber = requestDto.getPhoneNumber();
        this.point = requestDto.getPoint();
        this.smsAgreement = requestDto.getSmsAgreement();
        this.role = role;
    }

    public void updatePoint(UpdatePointDto updatePointDto) {
        this.point = updatePointDto.getPoint();
    }


}
