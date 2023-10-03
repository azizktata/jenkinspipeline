pipeline {
    agent any
    stages {
        stage('Checkout') {
           steps {
                checkout scm
           }
        }
        stage('Build Spring') {
            steps {
             script{
                sh 'mvn clean package'
             }
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