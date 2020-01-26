pipeline {
    agent any
    parameters {
        string(name: 'NICKNAME', description: 'Nickname of your stackOverflow account')
        string(name: 'EMAIL', description: 'Email of your stackOverflow account')
        string(name: 'PASSWORD', description: 'Password of your stackOverflow account')
        string(name: 'TITLE', description: 'Set title of your stackOverflow account')
        string(name: 'LOCATION', description: 'Set location of your stackOverflow account')
        string(name: 'ABOUT_ME_INFO', description: 'Set about me info of your stackOverflow account')
    }
    stages {
        stage('Initialising') {
            git url: 'https://github.com/yuriihalas/selenium_module_3.git'
        }
        stage('Cleaning') {
            steps {
                sh "mvn clean"
            }
        }
        stage('Compiling') {
            steps {
                sh "mvn compile"
            }
        }
        stage('Testing') {
            steps {
                sh "nvn test -Dnick=${params.NICKNAME}"
            }
        }
    }
    post {
        always {
            echo "Build is FINISHED"
        }
    }
}