


https://github.com/Nc-upadhyay/Jenkins-PROJECT/assets/108361583/27a24a73-ae33-46d1-a8c1-3a86c73f7eb0





![Screenshot (85)](https://github.com/Nc-upadhyay/Jenkins-PROJECT/assets/108361583/e2d0d763-73c3-4530-a550-5d529822ce04)



## Jenkins Pipeline Script Explanation

This Jenkins pipeline script is designed to automate the process of building, archiving, and deploying a Java web application using Maven and Tomcat. Here's a breakdown of each section:

### Agent
Specifies that the pipeline can run on any available agent.

### Tools
Defines the tools required for the pipeline. In this case, it specifies the path to Maven.

### Stages

#### pull
Checks out the source code from a Git repository (`https://github.com/Nc-upadhyay/Jenkins-PROJECT.git`) on the master branch.

#### build
Performs the build process of the application using Maven. The `mvn clean package` command is executed to clean the project, compile the source code, run tests, and package the application into a WAR (Web Application Archive) file.

##### Post-build actions
- **Success**: If the build is successful, it archives the generated artifact (WAR file) using the `archiveArtifacts` step.
- **Failure**: If the build fails, it echoes a message indicating the failure.

#### deploy
Responsible for deploying the application to a Tomcat server.
- The `deploy` step is used to deploy the WAR file to Tomcat.
- It specifies the Tomcat credentials (`credentialsId`), URL (`url`), and the WAR file to deploy (`war`).
- The `contextPath` specifies the context path under which the application will be deployed.
- `onFailure: false` ensures that if this stage fails, the pipeline will not stop execution.
