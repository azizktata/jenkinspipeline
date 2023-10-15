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
        stage('Build Spring') {
            steps {
                sh "mvn clean install"

            }
        }
        stage('Build docker image') {
            steps {
             script{
                sh 'docker build -t back-spring .'
             }
            }
        }
        stage('Run Docker Container') {
            steps {
                script {
                    sh 'docker compose up -d'
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
}