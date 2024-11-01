PJT6-B - REST API 전환

프로젝트 목표

	•	기존 Servlet 구조의 프로젝트(PJT4)를 Spring Boot 기반의 REST API로 전환
	•	컨트롤러, 서비스, DAO, DTO, 매퍼 등 주요 구성 요소를 재구성하여 각 역할을 분리
	•	MyBatis를 통해 데이터베이스와 상호작용하며, SQL 쿼리를 XML로 분리하여 관리

담당자 및 역할

	•	재현 - Video 모듈
	•	희주 - Review 모듈
	•	진호 - User 모듈

프로젝트 구조

주요 디렉토리 구성

src/main/java
├── com.ssafy.pjt_B
│   ├── PJT6BApplication.java      # Spring Boot 메인 클래스
│   ├── mvc.config
│   │   ├── DBConfig.java          # 데이터베이스 설정 클래스
│   │   └── WebConfig.java         # 웹 설정 클래스 (CORS, Interceptor 등)
│   ├── mvc.controller             # REST API 컨트롤러 패키지
│   │   ├── MainController.java
│   │   ├── ReviewController.java
│   │   └── UserController.java
│   ├── mvc.interceptor
│   │   └── AdminInterceptor.java  # 인증 및 권한 인터셉터
│   ├── mvc.model.dao              # DAO 클래스 패키지
│   │   ├── ReviewDao.java
│   │   ├── UserDao.java
│   │   └── VideoDao.java
│   ├── mvc.model.dto              # DTO 클래스 패키지
│   │   ├── Review.java
│   │   ├── SearchCondition.java
│   │   ├── User.java
│   │   └── Video.java
│   └── mvc.model.service          # 서비스 클래스 패키지
│       ├── ReviewService.java
│       ├── ReviewServiceImpl.java
│       ├── UserService.java
│       ├── UserServiceImpl.java
│       ├── VideoService.java
│       └── VideoServiceImpl.java
└── src/main/resources
    ├── mappers                    # MyBatis 매퍼 파일 패키지
    │   ├── ReviewMapper.xml
    │   ├── UserMapper.xml
    │   └── VideoMapper.xml
    └── application.properties      # 애플리케이션 설정 파일

주요 파일 설명

	•	PJT6BApplication.java: Spring Boot 메인 클래스이며 애플리케이션을 실행합니다.
	•	DBConfig.java: 데이터베이스 설정을 위한 클래스입니다. DataSource 및 트랜잭션 관리를 설정합니다.
	•	WebConfig.java: CORS 설정 및 Interceptor를 등록하여 웹 요청 관련 설정을 관리합니다.
	•	AdminInterceptor.java: 인증 및 권한 관리를 위해 특정 요청을 인터셉트하는 역할을 합니다.
	•	컨트롤러 (Controller): REST API 엔드포인트를 제공하며 클라이언트 요청을 처리합니다.
	•	서비스 (Service): 비즈니스 로직을 구현하며, DAO와 컨트롤러 사이에서 데이터 처리를 담당합니다.
	•	DAO (Dao): MyBatis를 통해 데이터베이스와 상호작용하며 SQL 쿼리를 실행합니다.
	•	DTO (Dto): 데이터 전송 객체로, REST API에서 요청 및 응답 데이터를 전달하는 역할을 합니다.
	•	매퍼 파일 (mappers): SQL 쿼리를 XML 파일로 분리 관리하여 코드와 SQL을 분리하고 유지보수를 용이하게 합니다.

Git 협업 방식

	•	메인 브랜치 사용: 별도의 브랜치 없이, 모든 작업은 메인 브랜치에 직접 푸시합니다.
	•	푸시 프로토콜: 메인에 푸시하기 전에 팀원들에게 알리고, 최신 상태를 유지하기 위해 푸시 후 다른 팀원들은 pull을 받은 뒤 작업을 진행합니다.
