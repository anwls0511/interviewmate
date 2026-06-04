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

    }

    post {
        success {
            echo 'Docker Build Success'
        }

        failure {
            echo 'Docker Build Failed'
        }
    }
}