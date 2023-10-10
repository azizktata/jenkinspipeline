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
                sh 'docker build -t firstSpring .'
             }
            }
        }
        stage('Run Docker Container') {
            steps {
                script {
                    sh 'docker run -d -p 8084:8084 firstSpring'
                }
            }
        }
    }
}