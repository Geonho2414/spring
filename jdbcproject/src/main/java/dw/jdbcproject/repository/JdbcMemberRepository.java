package dw.jdbcproject.repository;

import dw.jdbcproject.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// 우클릭 - 제너레이터 - implements method 선택 - ok
@Repository
public class JdbcMemberRepository implements MemberRepository{
    @Autowired
    DataSource dataSource;  // 데이터 베이스, SQL 관련 중요한 메서드들을 가지고 있는 인터페이스

    @Override
    public Member save(Member member) {
        String sql = "insert into members(name) values(?)";
        // SQL 페키지내의 클래스 정의
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 예외 처리
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getName());
            pstmt.executeUpdate();
            return member;
        } catch (Exception e){
            // 예외처리
            throw new IllegalStateException(e);
        } finally {
            // 연결종료
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    // close 메서드
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (pstmt != null){
                pstmt.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
