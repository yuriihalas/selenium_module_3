pipeline {
    agent any
    parameters {
        string(name: 'NICK', description: 'Nickname of your stackOverflow account')
    }
    stages {
        stage('Cleaning') {
            steps {
                mvn clean
            }
        }
        stage('Compile') {
            steps {
                git url: 'https://github.com/yuriihalas/selenium_module_3.git'
                echo "helloToAll"
            }
        }
        stage('Tests') {
            steps {
                echo "${params.NICK}"
            }
        }
        post {
            always {
                echo "Build is FINISHED"
            }
        }
    }
}