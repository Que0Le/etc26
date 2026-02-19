plugins {
	java
	id("org.springframework.boot") version "3.5.10"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "de.etc.sb"
version = "0.0.1-SNAPSHOT"
description = "Aufgabe 3"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.liquibase:liquibase-core")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	implementation("org.postgresql:postgresql")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
