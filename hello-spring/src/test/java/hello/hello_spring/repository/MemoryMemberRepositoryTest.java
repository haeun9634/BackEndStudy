package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //test 하나 끝날때마다 실행
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void Save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //System.out.println("result = " + (result ==member));
        /*
        Assertions.assertEquals(member,null);
        //member가 익스펙트, 기대하는값, member가 result가 되야함. 값이 같아야함
        //result에 null이 들어갈 경우 값 달라서 실패*/

        assertThat(member).isEqualTo(result);
        //member가 result랑 똑같애!
        //Assertions.asserThat 인데 Assertions import static 해서 생략가능?
    }

@Test
    public void FindByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void FindAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //단축키 shft+f6

        List <Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}


