pipeline {
    agent any
    parameters {
        string(name: 'NICK', description: 'Nickname of your stackOverflow account')
    }
    stages {
        stage('Cleaning') {
            mvn clean
        }
        stage('Compile') {
            git url: 'https://github.com/yuriihalas/selenium_module_3.git'
            echo "helloToAll"
        }
        stage('Tests') {
            echo "${params.NICK}"
        }
        post {
            always {
                echo "Build is FINISHED"
            }
        }
    }
}