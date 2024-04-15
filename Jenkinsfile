pipeline {
    agent any
    tools {
        maven 'maven_3_9_3'
    }
    stages {
        stage('Build Maven'){
            steps {
                checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/akshaypandare/BookProject']])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
        	steps {
        		script {
        			sh 'docker build -t book-devops-automation .'
        		}
        	}
        }
    }
}