FROM eclipse-temurin:17-jre
ADD /target/TechnicalDocumentationManagement-0.0.1-SNAPSHOT.jar TechnicalDocumentationManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","TechnicalDocumentationManagement-0.0.1-SNAPSHOT.jar"]