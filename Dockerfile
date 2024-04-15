FROM openjdk:11
EXPOSE 8080
ADD target/book-devops-automation.jar book-devops-automation.jar
ENTRYPOINT [ "java","-jar", "book-devops-automation.jar" ]