pipeline {
    agent any
    environment{
        def DOCKER_HUB_USERNAME = credentials('docker-hub-username')
        def DOCKER_HUB_PASSWORD = credentials('docker-hub-password')
        def ENVIRONMENT_CODE= ''
    }
    stages {

        stage("Compile") {

            steps {
                sh 'cd draailier-spring-boot && chmod +x gradlew'
                //        sh "./gradlew compileKotlin"
            }
        }
       
        stage("Package") {
            steps {
                sh "cd draailier-spring-boot && ./gradlew build"
            }
        }



        stage("Dockerize - Draailier Spring Boot -service ") {
            steps {



                sh "docker build -f Dockerfile -t speelyaal/draailier:0.1 ."
                sh "docker login -u ${DOCKER_HUB_USERNAME}  -p  ${DOCKER_HUB_PASSWORD}"
                sh "docker push speelyaal/draailier:0.1"
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