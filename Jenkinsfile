pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t interviewmate:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop interviewmate || true
                docker rm interviewmate || true
                docker run -d --name interviewmate -p 8080:8080 interviewmate:latest
                '''
            }
        }
    }

    post {
        success {
            echo 'InterviewMate CI/CD Success'
        }

        failure {
            echo 'InterviewMate CI/CD Failed'
        }
    }
}