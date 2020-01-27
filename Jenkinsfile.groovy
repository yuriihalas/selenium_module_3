pipeline {
    agent any
    tools {
        maven 'apache-maven-3.6.3'
    }
    triggers {
        pollSCM('') //Empty quotes tells it to build on a push
    }
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
            steps {
                git url: 'https://github.com/yuriihalas/selenium_module_3.git'
            }
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
                sh "mvn test -Dnick='${params.NICKNAME}' -Demail='${params.EMAIL}' -Dpass='${params.PASSWORD}'" +
                        " -Dtitle='${params.TITLE}' -Dlocation='${params.LOCATION}' -Dabout='${params.ABOUT_ME_INFO}'"
            }
        }
    }
    post {
        always {
            echo "Build is FINISHED"
        }
    }
}