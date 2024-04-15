pipeline {
    agent any
    tools {
        maven 'maven_3_9_3'
    }
    stages {
        stage('Build Maven'){
            steps {
                checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/akshaypandare/BookProject']])
                sh 'mvn clean install'
            }
        }
    }
}