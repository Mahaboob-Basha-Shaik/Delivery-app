# --- Build stage: build WAR with Maven ---
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Package WAR (skip tests for faster build)
RUN mvn clean package -DskipTests

# --- Run stage: deploy WAR to Tomcat ---
FROM tomcat:10.1-jdk17
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy WAR from build stage to Tomcat ROOT
COPY --from=build /app/target/SwiggiProject.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat default port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
