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
             git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
                     withMaven {
                       sh "mvn clean verify"
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