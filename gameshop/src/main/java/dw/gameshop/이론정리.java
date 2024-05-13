package dw.gameshop;

/*
// IT의 기술은 서로 융합하며 작용한다. 단 하나의 기술만 써야된다는 건 거의 없다.
   항상 모든 기술에는 대체할 수 있는 기술과 장단점이 있다. 그래서 모든 기술을 다 쓸 줄 알아야하는 것은 아니지만,
   알고는 있어야 나중에 어떤 기술이 우리에게 최적한지 결정하여 쓸 수 있다. 그것이 우리가 용어들을 알아야 하는 이유이다.




[ Spring 시스템 ]
Model : 데이터 베이스를 생성하는 성실 정의
repository : 데이터 베이스를 JPA 를 통해 사용을 할 수 있도록 호출
repository : Service로 데이터를 불러와 가공하여 기능을 구현
controller : Service 의 데이터와 기능을 불러와 톰캣(Servlet Container)을 통해서 웹과 통신
exception : 기능 중 발생하는 모든 예외를 모아서 처리
Dto : 원하는 정보만 뽑아서 출력하는 기능




[ HTML ]
 // 이론
HTML : Hyper Text Markup Language : 내가 원하는 페이지로 이동하도록 설정되어있는 정보 언어.
구조 이론:
    HTML
          |
          \-HEAD
          |  |
          |  \-TITLE
          |      |
          |      \-<TITLE>
          |      |
          |      \-"Parsing Example"
          |      |
          |      \-</TITLE>
          |
          \-BODY
            |
            \-P
              |
              \-<P>
              |
              \-"Some text. "
              |
              \-EM
              |  |
              |  \-<EM>
              |  |
              |  \-"*wow*"
              |  |
              |  \-</EM>
              |
              \-</P>
 // 사용법
구조 세부 :
    <!DOCTYPE html>         // HTML 의 버전
    <html lang="en">        // HTML 시작, HTML 의 언어 "en"의 자리에 "ko"를 넣으면 한국어를 주로 사용하겠다는 말이다
    <head>          // head 태그 : 현재 이 웹 페이지에 대한 설명/설정을 넣어주고 외부 파일을 연결시켜주는 기능.
                    // 사용자에게 직접적으로 나타나지 않는다. 작성을 하지 않아도 상관이 없으나 검색 엔진에 노출 되기 위하여 작성.
        <meta charset="UTF-8">          // 문자코드 정의
        <meta name="viewport" content="width=device-width, initial-scale=1.0">      // 어떤 디바이스(모바일, PC등)에서 사용할 것인지 결정
        <title>Document</title>         // 페이지 제목
    </head>         // head 종료
    <body>          // body 태그 : 사용자에게 보여지는 웹페이지의 실질적인 내용.
    </body>         // body 종료
    </html>         // HTML 종료
HTML 단축키 :
 - !를 치고 엔터를 치면 HTML 의 기본 태그들을 만들어준다.
태그 :
 - HTML 에서 <HEAD>, <BODY> 등 괄호로 묶여 앞에서 정의를 해주는 것을 태그라고 부른다.
 - < > 는 시작태그, < /> 는 종료 태그이다. 대부분의 태그는 종료 태그가 있다(<input> 태그는 없다).
 - 주석 : <!-- 내용 -->
태그의 종류 :
 1. 블록태그 : 한 블록을 자신의 영역으로 정한다.
     1. <br> 태그 : Java의 Break처럼 줄을 중단시켜주는 역할을 하게 된다. 종료태그는 사용하지 않는다.
     2. <p> </p> 태그 : 사이에 내용을 넣으면 띄어쓰기가 된다. P는 단락을 의미하기 때문에 윗줄과 간격이 생긴다.
     3. <div> </div> 태그(블록태그) : '나누기'를 의미한다. 다른 줄과 나누어 자신의 영역을 구분한다. p와 달이 위아래 내용에 간격이 없다. **가장 많이 사용한다.
     4. <h1> </h1> 태그 : h뒤에 숫자가 올라갈수록 글씨가 작아진다. (ex) <h5> </h5> (엔터가 작용한다.)
 2. 인라인태그 : 주로 블록 안에서 작동하며, 글자 수 만큼이 자신의 영역이다.
     1. <span> </span> 태그 : 인라인 태그
     2. <b> </b> 태그 : bold, 전체 문장 글씨강조
     3. <strong> </strong> 태그 : strong, 문단또는 단락에서 강조하고 싶은 부분'만' 강조
     4. <img src=""> 태그 : 이미지 표시

 // 용어
ietf : 인터넷 국제 표준 기구
 - ietf 에서는 인터넷 사용자들의 혼란을 막기 위해 Html 와 CSS 표준작성법을 만들었다.
 - ietf 의 표준작성법 내용에서 벗어나 코딩을 하게 되면 인터넷상에서 사용이 불가능하다.
개발자 도구 :
 - f12를 누르면 이 웹페이지에 관련된 HTML, 네트워크등 정보를 알 수 있다.




[ CSS ]




[ tomcat ]
: Servlet Container 이다. 자바와 웹 브라우저 사이의 통신을 담당한다.




[ JPA ]
DataBase 와 스프링 사이의 통신을 담당.




[ JDBC ]
 //이론
JDBC : Java Data Base Connectivity
우리가 코드를 짤 수도 있지만 주로 JPA 가 자동으로 생성/사용함.
기본 데이터 베이스 통신 구조 : DAO - JDBC - JDBC implements - DataBase
                          이 기본 구조를 벗어나지 않고 여기서 어떤 기술을 사용할것인가가 관건이다.
데이터 베이스와 스프링 통신의 2가지 종류 :
1. ORM 을 사용하는 방법
2. SQL 을 사용하는 방법 (비 ORM 방식)
   이 SQL 을 사용하는 3가지 방법
    1. JDBC
      - 중복되는 코드가 너무 많아서 요즘엔 잘 안쓰는 기술.
    2. JDBC Template
      - 템플릿을 가져와서 사용하는 기술.
    3. MyBatis
      - 가장 많이 쓰이는 기술 / JPA 아니면 MyBatis 를 가장 많이 사용.
 //사용법
: Spring io 에서 DeveloperTool 에서 jpa 대신 SpringJDBC 를 선택. 나머지는 동일
  이후 사용법은 jdbcproject 파일 참조.
 //용어
DAO : Database Application Object (Repository)
      흔히 Repository 인데, 만약 ORM 을 사용한다면 거의 한줄로 정의가 가능해서 별로 쓰이지 않는 용어.
      JDBC 를 사용한다면 여기에 SQL 문을 작성해야 한다.




[ 스프링 시큐리티 ]
 //이론
인증/인가
인증 : 대표 인증방식
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
 //핵심용어
username
password
ROLE_()




[ CSR / SSR ]
 //이론
Rendering : 렌더링은 2D / 3D 가 있는데 2D는 그냥 빛과 색이 있으면 된다. 그러나 3D는 입체이다.
            광원과 그림자, 광원에서 오는 빛의 반사가 작용하여 입체감을 만드는데 그것을 컴퓨터 그래픽으로 구현하는 것이
            렌더링이다. 이 랜더링을 해주는것이 렌더링 라이브러리*
CSR : Client Side Rendering
      CSR 은 렌더링을 고객(모바일등)에서 하고, 서버는 정보를 보내주는 것만하면 된다.
      장단점 :
       - 페이지를 구성하는 초기로딩 속도는 길다. 그러나 한번 로딩을 해놓으면 다시 로딩을 할 필요가 없다.
       - 모든 정보를 받고, 그 중에서 원하는 정보를 추려내는 것이기 때문에 네트워크가 할 일이 많다.
SSR : Server Side Rendering
      서버에서 렌더링을 해서 페이지를 이미 만들어놓고, 고객에게 전달해주는 것이다.
      SSR 의 종류 2가지
       1. 정적 : 한번 정해놓으면 그대로 있음
       2. 동적 : 계속 바뀌는 페이지
      장단점 :
       - 이미 만들어진 페이지를 보내주기 때문에 초기로딩은 빠르다.
         그러나 매번 페이지를 보내줘야하기 때문에 중간중간 다시 로딩을 해야 한다.
       - 완성품 페이지를 그대로 전해주는 것이기 때문에 서버가 할 일이 많다.
CSR vs SSR  : 점점 고화질 컨텐츠가 많이 나오면서 SSR vs CSR 에서 CSR 이 승리하고 대세가 되었다.
              그러다 SEO 때문에 상황이 반전된다. 검색엔진은 페이지를 읽고 알고리즘에 검색결과를 띄워준다.
               - CSR 은 사용자가 페이지를 조합하는 것이기 때문에 검색엔진이 읽을때는 빈 페이지라고 나온다는 것이다.
               - SSR 은 페이지에 HTML 을 포함하기 때문에 검색엔진이 읽고, 상위 검색에 띄워주는 것이다.
              그래서 지금은 CSR + SSR 이 유행이 되는 것이다.
              CSR 으로 자주가는 페이지를 만들고, 자주 가지 않는 페이지는 SSR 으로 만들어 검색 엔진에 노출한다.
이 기술을 사용할 수 있는 프레임 워크가 Next.js 이다. = 풀스택을 개발할 수 있는 프레임워크이다.
 //용어
유명한 그래픽 라이브러리들*
 - OpenGL, DirectX, Vercan
Search Engine : 검색엔진
 - 전세계를 돌아다니면서 계속 웹 페이지를 읽고, 저장하며 빅데이터를 모으고,
   알고리즘을 이용해 검색된 키워드와 조합을 해서 검색결과를 띄워주는 것이다.
SEO : Search Engine Optimization - 검색 엔진 최적화
 - 내 컨텐츠가 검색 상위에 올라가는 것. 마케팅  ex) 유튜브 알고리즘, 네이버 실검




[ Servlet ]
 //이론
Servlet : Http(SMTP, FTP 등) 같은 '웹' 통신규칙을 제어하기 위한 '자바' 인터페이스의 구현체.(자바 소프트웨어)
          자바가 용의성에 의해서 SSR 동적 페이지 (HTML 이 포함되어있는 페이지)를 만들게 되면서 브라우저와 통신하는 기능도 생기게 된 것.
          HTTP 에서 요청이 오면 서블릿이 컨트롤러와 연결해주는 것이다. = 즉 톰캣과 역할이 똑같다.
          엄청나게 많은 역할을 하고 있으며, 그 자체가 완벽한 '앱'이다. 스프링없이 서블릿만으로 서버를 구성할 수도 있다.
Servlet Container : 톰캣이 Servlet Container(서블릿을 담고 있음)이다.
                    서블릿을 잔뜩 담고 있는 것 = Servlet Container = 톰캣이다. (ex : 톰캣 = 그루, 서블릿 = 미니언즈들)




[ Merge Tool]
: 서로 다른 버전의 코드를 버전이 동일 하도록 옮기는 도구

*/
