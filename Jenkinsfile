pipeline {
    agent any
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
                sh 'ls -la'
                sh 'pwd'
            }
        }


        stage('Test') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn test'
            }
        }

        stage('Start container') {
            steps {
                sh 'echo Prune Docker data'
                sh 'docker system prune -a --volumes -f'

                sh 'Start container'
                sh 'docker compose up -d --no-color --wait'

                sh 'ls -la'
                sh 'pwd'
                sh 'docker compose ps'

            }
        }

    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}