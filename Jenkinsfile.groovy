def DRAAILIER_VERSION= ''
pipeline {
    agent any
    environment{
        def DOCKER_HUB_USERNAME = credentials('docker-hub-username')
        def DOCKER_HUB_PASSWORD = credentials('docker-hub-password')
        def ENVIRONMENT_CODE= ''
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    stages {

        stage("Compile") {

            steps {
                script {
                    def version_value = sh(returnStdout: true, script: "cd draailier-spring-boot && cat build.gradle.kts | grep -o 'version = [^,]*'").trim()
                   // sh "echo Project in version value: $version_value"
                   // DRAAILIER_VERSION = '0.22'
                    DRAAILIER_VERSION = version_value.split(/=/)[1].trim()
                    DRAAILIER_VERSION = DRAAILIER_VERSION.trim()
                   // sh "echo ++++++++++++++++++++++++++++++++++++++++++++++++"
                   // sh "echo final version: $DRAAILIER_VERSION"
                    sh 'cd draailier-spring-boot && chmod +x gradlew'
                }


            }
        }
       
        stage("Package") {
            steps {
                sh "cd draailier-spring-boot && ./gradlew build"
            }
        }



        stage("Dockerize - Draailier Spring Boot -service ") {
            steps {



                sh "docker build --build-arg SERVICE_VERSION=${DRAAILIER_VERSION} -f Dockerfile -t speelyaal/draailier:${DRAAILIER_VERSION} ."
                sh "docker login -u ${DOCKER_HUB_USERNAME}  -p  ${DOCKER_HUB_PASSWORD}"
                sh "docker push speelyaal/draailier:${DRAAILIER_VERSION}"
            }
        }

         stage("Cleanup Jenkins") {
            steps {
                script {
                    sh "docker system prune -f"
                }

            }

        }

    }
}