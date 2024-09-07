package hello.hello_spring.service;
//서비스 class는 비지니스 관련 로직

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        //외부에서 멤버리포지토리를 가져오도록 바꿈. 직접 생성 XX
    }

    //회원 가입
    public Long join(Member member) {
        //같은 이름이 안된다고 가정

        validateDuplicateMember(member);// 중복 회원 검증
        memberRepository.save(member);
        return member.getId();

        /*
        //반환 단축키 ctrl+alt+v, null이면 Optional로 감싸서 꺼냄
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {//ifPresent null이 아니라 값이 있으면?
            throw new IllegalAccessException("이미 존재하는 회원입니다.");
        }); */


    }

    private void validateDuplicateMember(Member member) {
        //result 생략 가능
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

    }
    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
