package jpabook.jpashop;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional // spring껄로 쓰자.
    @Rollback(false)
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo((member.getId()));
        Assertions.assertThat(findMember.getUsername()).isEqualTo((member.getUsername()));
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member" + (findMember == member));
        // r같은 transaction 안에서 저장하고 출력하면, 같은 영속성 컨텍스트. 같은 영속성 컨텍스트 안에서는 id 값 같으면, 같은 entity로 식별한다.
        // 그래서 select문도 안쓰고 바로 쭉 꺼내왔다.
    }
}