package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    //new 만들지말고 스프링 컨테이너에 딱 하나 등록
    @Autowired//생성자 호출할때 autowired가 있으면 스프링 컨테이너에서 멤버 서비스 가져옴
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
//스프링 처음에 뜰때 스프링 컨테이너라는 스프링 통이 생기는데
//이 컨트롤러가 있으면 멤버 컨트롤러 객체를 생성해서 스프링에 넣어둠.. 뭐라는거야
