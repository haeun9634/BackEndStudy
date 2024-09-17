package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {
    //여기에 인터페이스만 있는데 이러면 스프링 데이터 jpa가 jpa 리포지토리를 받고있으니까 자동으로 만들어줌
    //자기가 직접 구현체 만들어서 등록했으므로 이걸 가져다 쓰면 됨. 
    @Override
    Optional<Member> findByName(String name);
}
