package dw.jdbcproject.repository;

import dw.jdbcproject.model.Member;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

// JDBC Template : 반복되는건 Template 이 다 해준다. 함수를 리턴하여 값이 아닌 방법을 리턴한다
@Repository
@Primary  // 구현체 2개가 동일할 시 어떤 구현체를 우선시 할지 지정.
// ex) findAll 이 JdbcMemberRepository 에도, JdbcTemplateMemberRepository 에도 존재하기 때문에 @Primary 로 어떤 구현체를 사용할지 지정하는것.
public class JdbcTemplateMemberRepository implements MemberRepository{
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public Member save(Member member) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {PreparedStatement ps = con.prepareStatement("insert into members(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            return ps;
        }, keyHolder);
        member.setId(keyHolder.getKey().longValue());
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return jdbcTemplate.query("select * from members where id = ?", memberRowMapper(), id).stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return jdbcTemplate.query("select * from members where name = ?", memberRowMapper(), name).stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from members", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong(1));
            member.setName(rs.getString(2));
            return member;
        };
    }
}
