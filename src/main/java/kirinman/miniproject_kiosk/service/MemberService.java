package kirinman.miniproject_kiosk.service;


import kirinman.miniproject_kiosk.dto.OrderRequestMsgDto;
import kirinman.miniproject_kiosk.dto.member.LoginRequestDto;
import kirinman.miniproject_kiosk.dto.member.MemberJoinRequestDto;
import kirinman.miniproject_kiosk.entity.Member;
import kirinman.miniproject_kiosk.entity.MemberRoleEnum;
import kirinman.miniproject_kiosk.jwt.JwtUtil;
import kirinman.miniproject_kiosk.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private  final JwtUtil jwtUtil;

    @Transactional
    public OrderRequestMsgDto joinMember(MemberJoinRequestDto requestDto, HttpServletResponse response){
        String phoneNumber = requestDto.getPhoneNumber();

        String regExp = "^010-(\\d{4})-(\\d{4})$";

        MemberRoleEnum role = MemberRoleEnum.MEMBER;

        if(!phoneNumber.matches(regExp)){
            return new OrderRequestMsgDto("번호는 11자리여야 합니다.", HttpStatus.BAD_REQUEST.value());
        }

        Member join = memberRepository.findByPhoneNumber(phoneNumber);
        if (join != null) {
            return new OrderRequestMsgDto("이미 등록된 번호입니다.", HttpStatus.BAD_REQUEST.value());
        }
        Member member = new Member(requestDto,role);
        memberRepository.saveAndFlush(member);

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        return new OrderRequestMsgDto("승인", HttpStatus.OK.value());
    }

    //추가로 로그인 기능이 필요하지 않을 것 같아 일단 주석처리 해 두었습니다.
    public OrderRequestMsgDto login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String phoneNumber = loginRequestDto.getPhoneNumber();

        String regExp = "^010-(\\d{4})-(\\d{4})$";

        if(!phoneNumber.matches(regExp)){
            return new OrderRequestMsgDto("번호는 11자리여야 합니다.", HttpStatus.BAD_REQUEST.value());
        }

        Member member = memberRepository.findByPhoneNumber(phoneNumber);
        if (member == null) {
            return new OrderRequestMsgDto("등록된 회원이 아닙니다.", HttpStatus.BAD_REQUEST.value());
        }

        return new OrderRequestMsgDto("확인", HttpStatus.OK.value());
//
//        response.addHeader(JwtUtil.AUTHORIZATION_HEADER,
//                jwtUtil.createToken(member.getPhoneNumber(),member.getRole()));

    }


}
