# Spring Social Showcase with Spring Data JPA

##### from https://github.com/spring-projects/spring-social-samples/tree/master/spring-social-showcase-boot


```
SpringBoot + Spring Data JPA + Spring Social
```

- 최신 라이브러리로 업데이트 하였습니다. (SpringBoot 1.3.1)
- localhost:8080 에서 바로 테스트 해볼 수 있도록 수정하였습니다.
- 링크드인은.. 제외하였습니다. (로컬호스트로 바로 테스트가 잘 안되네요 ㅠ)
- 메이븐 프로젝트로 변경 하였습니다. (STS설치 후 바로 테스트 가능합니다. 어떠한 추가 플러그인도 필요 없습니다.)
- JPA지원하도록 수정하였습니다. (이것때문에 따로 작업합니다.)


### Quick Start

- JDK 1.8 or later
- Maven 3.0+

```
git clone https://github.com/origoni/spring-social-showcase-boot-with-spring-data-jpa.git
cd spring-social-showcase-boot-with-spring-data-jpa
mvn spring-boot:run
```

- visit [http://localhost:8080/](http://localhost:8080/)


## Spring Social Showcase (Spring Boot)

This sample app demonstrates many of the capabilities of the Spring Social project, including:
* Connect to Facebook and Twitter
* Sign in using Facebook, Twitter in using ProviderSignInController for provider-signin

### Step 1: Register your application

Before you can run the application, you'll need to obtain application credentials from Facebook and Twitter by registering the application with each of the service providers:

 * Facebook: https://developers.facebook.com/apps
 * Twitter: https://apps.twitter.com/

Be sure to read each platform's usage policies carefully and understand how they impact your use of Spring Social with those platforms.

### Step 2: Edit application.yml

Once you have registered the application, you'll need to edit src/main/resources/application.yml, adding the credentials to the appropriate properties.

###Step 3: Run the application

```
git clone https://github.com/origoni/spring-social-showcase-boot-with-spring-data-jpa.git
cd spring-social-showcase-boot-with-spring-data-jpa
mvn spring-boot:run
```

- visit [http://localhost:8080/](http://localhost:8080/)

When running the application from the command line, you can access it at http://localhost:8080 from your browser.
