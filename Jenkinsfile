pipeline {
    agent any
     tools {
          maven 'maven'
     }
    stages {

        stage('Checkout') {
           steps {
                checkout scm
           }
        }

        stage ("Generate backend image") {
            steps {
                 dir("jenkinspipeline"){
                    sh "mvn clean install"
                    sh "docker build -t back-spring ."
                }
            }
        }
        stage('Run Docker Container') {
            steps {
                dir("jenkinspipeline") {
                    sh 'docker compose up -d'
                }
            }
        }

    }
    post {
        always {
                    // Cleanup or post-build actions
            deleteDir() // This will delete the workspace directory
        }
    }
}