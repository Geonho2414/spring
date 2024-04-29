package dw.jdbcproject.repository;

import dw.jdbcproject.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 인터페이스는 추상메서드
    Optional<Member> findById(Long id); // jdbc 는 jpa 와 달리 작명법이 지정되어있지 않다. 원하는 대로 하면 된다.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
