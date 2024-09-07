package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach //각 테스트 실행하기 전에 실행
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    /*
    MemberService memberService = new MemberService();
    //멤버 서비스 만듦! MemberService 밖에 없으면 클리어가 안됨
   MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    //다른 객체 레포지토리 생성하면 내용물이 달라질수도 있음....
    //즉 여기서 new MemoryMemberRepository랑 멤버 서비스에서 사용하는
    MemoryMemberRepository랑 다른 인스턴스라서 만약에 MemoryMemberRepository가 static이 아니면 문제 생김..
    // 아무튼 다른게 생겼으니까 안됨. 같은걸로 해야함!!
    */




   @AfterEach //test 하나 끝날때마다 실행
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 무언가 주어졌는데
        Member member = new Member();
        member.setName("hello");

        //when 이걸 실행했을때
        Long saveId = memberService.join(member);

        //then 결과가 이렇게 나와야함!
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //assertThrows(IllegalStateException.class, () -> memberService.join(member2));

//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then

    }

    @Test
    void findMembers() {

    }

    @Test
    void findMember() {

    }
}