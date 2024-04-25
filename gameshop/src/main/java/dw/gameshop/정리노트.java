package dw.gameshop;

/*
[ tomcat ]



[ Dto ]



[ JPA ]



[ 스프링 시큐리티 ]

// 이론
인증/인가
인증 : 대표 인증방식 {
1. 세션
  - username 과 password 로 로그인을 하면 세션이 만들어진다 / 세션 ID 는 만료기간이 있으며, 만료기간 후에는 로그아웃이 된다.
  - 세션은 고유의 세션 ID로 서버와 사용자간 요청하는 모든 패킷애 포함되어 요청을 처리한다. (Cookie 라고 부름)
  - 사용자와 서버는 세션 ID (유저 -> 톰캣 -> 서버 -> 세션서버확인)로 서로를 알아볼 수 있다.
  - 단점 : 요청하는 모든 패킷에 세션 ID가 들어있다보니 세션 ID를 가로채서 해킹을 당할 가능성이 있다.
       : 중간에 네트워크 Gateway 에 스파이웨어를 심어놓아 세션 ID를 가로채면 수천만명의 아이디를 훔칠 수 있다.
       : 매번 세션 ID를 보내주기 때문에 유저 -> 톰캣 -> 서버 -> 세션서버확인 이 과정을 매번 반복하는것이 서버에 부하가 된다.
  - 요즘은 세션 ID 의 시대가 끝나고 쿠키는 세션 ID 의 역할보다는 다른 역할로 많이 알려지게 되었다.
2. 토큰 JWT //매우 중요!!
  - 로그인을 할때 2가지,
        엑세스 토근 : 이름과 만료시간을 가지고 있다.
        리프레쉬 토큰 : 계속 리프레쉬를 해 시간을 번다.
    을 준다.
  - 그렇다면 세션과의 차이점은? 세션 서버가 없다. [유저 - 톰캣 - 서버] 만료시간을 가지고 다니기 때문에 세션서버 X
  - 로그인, 비밀번호 노출 X : 처음 한번만 사용됨.
  - 해커가 리프레쉬를 뚫는다고 해도 안에 엑세시 토큰을 뚫어야 되기때문에 시간이 많이 걸린다.
3. OAuth2 //요즘 많이 씀
  - 인증 대행 사이트 이용(ex 구글아이디, 카카오톡 아이디등)
  - 요즘 엄청 많이 씀.

// 핵심용어
username
password
ROLE_()
 */
