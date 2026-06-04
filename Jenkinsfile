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
                docker run -d --name interviewmate -p 8081:8080 -e SPRING_DATASOURCE_URL=jdbc:mariadb://interviewmate-mariadb:3306/interviewmate -e SPRING_DATASOURCE_USERNAME=interviewmate -e SPRING_DATASOURCE_PASSWORD=1234 -e SPRING_DATA_REDIS_HOST=interviewmate-redis -e SPRING_RABBITMQ_HOST=interviewmate-rabbitmq -e OPENAI_API_KEY=test interviewmate:latest
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