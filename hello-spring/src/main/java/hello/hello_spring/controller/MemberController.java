package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//컴포넌트 스캔이기 때문에 오토와이어로 해야함. 스프링 빈으로 하면 안됨
public class MemberController {

    private final MemberService memberService;
    //new 만들지말고 스프링 컨테이너에 딱 하나 등록
    @Autowired//생성자 호출할때 autowired가 있으면 스프링 컨테이너에서 멤버 서비스 가져옴
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //url에 직접 친 거는 얘가 매핑됨.조회할때 씀
    public String createForm(){
        return "members/createMemberForm";//그냥 이동 시켜줌
    }

    @PostMapping("/members/new") //post mapping은 데이터를 뭔가 전달할때, 등록할때
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);//멤버 가입

        return "redirect:/";//회원 가입 끝나면 홈화면으로 돌림
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
        //model에서 memers라는 key에 members라는 리스트를 넣었음.
    }
}
//스프링 처음에 뜰때 스프링 컨테이너라는 스프링 통이 생기는데
//이 컨트롤러가 있으면 멤버 컨트롤러 객체를 생성해서 스프링에 넣어둠.. 뭐라는거야
