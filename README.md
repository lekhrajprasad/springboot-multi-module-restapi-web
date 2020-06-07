# springboot-mongodb
crud operation using spring boot , mongo db, rest, to test use postman
view-source:http://localhost:1111/customerapi/api/mongo/emp/getall

lombok
Enable annotation processor in intelij
1) Enable Annotation Processing
File -> Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> (Tick the checkbox as per the image given below)
2) Install/Update Lombok Plugin (see this)
File -> Settings -> Plugins -> Search for Lombok Plugin -> Update or Install

to upload to mavenLocal() repo
mvn install:install-file -Dfile=lombok-model-0.0.1-SNAPSHOT.jar -DgroupId=com.lpras.email -DartifactId=lombok-model -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar

mvn install:install-file -Dfile=springboot-mongodb-repo-1.1.1-SNAPSHOT.jar -DgroupId=com.lpras.springboot.mongodb -DartifactId=springboot-mongodb-repo -Dversion=1.1.1-SNAPSHOT -Dpackaging=jar

To run application as Springboot in intelliJ or any ide => enable include dependency as provided scope
