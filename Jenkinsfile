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

        stage('Prune Docker data') {
            steps {
                sh 'docker system prune -a --volumes -f'

            }
        }

        stage('Start container') {
            steps {
                sh 'docker-compose up -d --no-color --wait'
                sh 'docker-compose ps'
            }
        }

    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}