package dw.jdbcproject.service;

import dw.jdbcproject.model.Member;
import dw.jdbcproject.repository.JdbcMemberRepository;
import dw.jdbcproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository; // 약한 결합. 구현체 자체가 아니라 인터페이스를 가져와 의존성 주입을 해야한다.

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
