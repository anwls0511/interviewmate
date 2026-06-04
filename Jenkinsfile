pipeline {
    agent any

    stages {

        stage('Git Clone') {
            steps {
                git branch: 'main',
                url: 'https://github.com/anwls0511/interviewmate.git'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test'
            }
        }

    }
}