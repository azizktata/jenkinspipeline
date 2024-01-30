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

stage ("Deploy to k8s"){
            steps {
                withKubeCredentials(kubectlCredentials: [[caCertificate: '', clusterName: 'k8s-cluster', contextName: '', credentialsId: 'SECRET_KEY', namespace: 'default', serverUrl: 'https://192.168.1.20:6443']]) {
                sh 'curl -LO "https://storage.googleapis.com/kubernetes-release/release/v1.20.5/bin/linux/amd64/kubectl"'
                sh 'chmod u+x ./kubectl'
                sh './kubectl get nodes'
                sh './kubectl apply -f ./manifests/mysql-deployment.yml'
                sh './kubectl apply -f ./manifests/spring-deployment.yml'
            }
            }

        }


    }
    post {
        always {
                    // Cleanup
            deleteDir()
        }
    }
}