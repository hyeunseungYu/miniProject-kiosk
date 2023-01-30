package kirinman.miniproject_kiosk.controller;


import kirinman.miniproject_kiosk.dto.OrderRequestMsgDto;
import kirinman.miniproject_kiosk.dto.member.LoginRequestDto;
import kirinman.miniproject_kiosk.dto.member.MemberJoinRequestDto;
import kirinman.miniproject_kiosk.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member/join")
    public OrderRequestMsgDto signup(@RequestBody MemberJoinRequestDto joinRequestDto, HttpServletResponse response) {
        return memberService.joinMember(joinRequestDto,response);
    }

    @PostMapping("/member/login")
    public OrderRequestMsgDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return memberService.login(loginRequestDto, response);
    }
}