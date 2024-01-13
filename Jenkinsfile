pipeline {
    agent any
     tools {
          maven 'maven'
     }
     environment {
                  DOCKERHUB_CREDENTIALS = credentials('dockerhub_id')
              }
    stages {

        stage('Checkout') {
           steps {
                checkout scm
           }
        }

        stage ("Generate backend image") {
            steps {
                 script{
                    sh "mvn clean install -DskipTests"
                    sh "docker build -t aziz77/garage-back:1.0 ."
                }
            }
        }
        stage('Push to DockerHub') {
            steps {
                script {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh 'docker push aziz77/garage-back:1.0'
                }
            }
        }

//         stage('Run Docker Container') {
//             steps {
//                 script {
//                     sh 'docker compose up -d'
//                 }
//             }
//         }

    }
    post {
        always {
                    // Cleanup or post-build actions
            deleteDir() // This will delete the workspace directory
        }
    }
}