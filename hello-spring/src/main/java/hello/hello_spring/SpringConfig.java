package hello.hello_spring;

import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    //멤버 서비스랑 리포지토리 둘다 스프링 빈에 등록을 하고
    //스프링 빈에 등록되어 있는 리포지토르를 서비스에 등록해줌

    /*
        @Autowired
        DataSource datasource; //이렇게 하거나 */

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }//construct한것도 spring 빈이 관리하므로 자체적으로 자동으로 생성해줌
    //연결할 수 잇는 정보 그런걸 알아서 주입해줄거임

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
