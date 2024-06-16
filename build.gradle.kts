plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	war
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	//implementation("javax.servlet:jstl:1.2")	
	//providedRuntime("javax.servlet:javax.servlet-api:4.0.1")	
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	
	
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.44")
	runtimeOnly("com.mysql:mysql-connector-j")
	
}

tasks.withType<Test> {
	useJUnitPlatform()
}
