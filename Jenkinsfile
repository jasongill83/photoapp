node {
   stage('init') {
      checkout scm
   }
   stage('build') {
      sh "./gradlew clean assemble"
//      sh '''
//         mvn clean package
//         cd target
//         cp ../src/main/resources/web.config web.config
//         cp todo-app-java-on-azure-1.0-SNAPSHOT.jar app.jar 
//         zip todo.zip app.jar web.config
//      '''
   }
}
