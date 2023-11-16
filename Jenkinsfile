pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building Project'
                git 'https://github.com/ankitroh88/PlanitAssignment.git'
                bat 'mvn dependency:resolve'
                bat 'mvn clean'
                bat 'mvn test-compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Running Tests'
                bat 'mvn test'
            }
        }
        stage('Archive') {
            steps {
                echo 'Archiving Test Results'
                archiveArtifacts artifacts: 'test-output/emailable-report.html', followSymlinks: false
            }
        }
    }
}
