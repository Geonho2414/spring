package dw.gameshop.config;

import dw.gameshop.exception.MyAccessDeniedHandler;
import dw.gameshop.exception.MyAuthenticationEntryPoint;
import dw.gameshop.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailService userDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 중요! filterChain : 보안사항을 체크하는 필터가 모아져 있는것!
        return http
                .authorizeRequests(auth -> auth
                        .requestMatchers(  // 예외 : 이 안에 들어있는것만 인증을 허용하겠다.
                                new AntPathRequestMatcher("/products/**"),
                                new AntPathRequestMatcher("/user/login"),
                                new AntPathRequestMatcher("/user/signup"),
                                new AntPathRequestMatcher("/login")
                        ).permitAll()
                        .anyRequest().authenticated())  // 스프링 시큐리티의 디폴트 상태 : 어떠한 요청이든 인증을 받겠다.
                .formLogin(form->form.loginPage("/login")   // 내가 직접 만든 로그인 화면을 사용하겠다.
                        .defaultSuccessUrl("/articles"))   // 로그인이 성공하면 이 주소로 이동하라
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))   // 항상 세션 ID를 사용하겠다.
                .csrf(AbstractHttpConfigurer::disable)
                    // csrf : 다른 사이트에서 내 사이트로 접속하는 것을 막음 우리는 더 고급보안을 사용하기에 disable 해놓자!
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new MyAuthenticationEntryPoint())   // 인증실패
                        .accessDeniedHandler(new MyAccessDeniedHandler()))  // 권한실패
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       BCryptPasswordEncoder bCryptPasswordEncoder,
                                                       UserDetailService userDetailService) throws Exception {
        // BCrypt : <매우중요!!>  암호화 해시 함수 = 디코딩(풀기)이 불가능한 암호화 방법
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(authProvider);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
