# 1. JDK 17을 사용하여 빌드
FROM openjdk:17-jdk-slim AS builder
WORKDIR /app

# 2. 프로젝트 파일들을 컨테이너로 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# 3. Gradle 실행 권한 부여
RUN chmod +x ./gradlew

# 4. Spring Boot 애플리케이션 빌드 (bootJar 실행)
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim
WORKDIR /app

# 6. 빌드한 JAR 파일을 실행 이미지로 복사
COPY --from=builder /app/build/libs/*.jar app1.jar

# 7. 로그 저장을 위한 디렉터리 생성
RUN mkdir -p /app/logs

# 8. 환경 변수 설정
ENV SPRING_PROFILES_ACTIVE=prod
ENV SERVER_PORT=8081

# 9. 컨테이너에서 노출할 포트 설정
EXPOSE 8081

# 10. 컨테이너가 실행될 때 수행할 명령어 지정
ENTRYPOINT ["java", "-jar", "app1.jar"]