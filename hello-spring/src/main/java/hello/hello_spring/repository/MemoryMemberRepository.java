package hello.hello_spring.repository;
//단순 데이터 넣고 빼는 것
import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
//alt + 엔터

    //ctrl + space
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //key값 생성해주는 애

    @Override
    public Member save(Member member) {
        member.setId(++sequence);//id는 시스템이 정해줌
        store.put(member.getId(), member);//store에 넣기 전에 멤버 아이디 세팅
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //return store.get(id);//결과 없으면 어떡함? optional로 감싸서 null로 가는게 아니게 바꿈
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //끝까지 돌려서 찾음
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        //store에 있는 멤버들이 쫙 반환되도록 구현
    }
    
    public void clearStore(){
        store.clear();//store 싹 비우기
    }
}
