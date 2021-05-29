pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
    	stage('Zero') {
            steps {
                echo "${hostname}"
                echo "${HOSTNAME}"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {	
                sh 'mvn verify -P tomcat8x' 
            }
            post {
                always {
                    junit 'book-functional-tests/target/failsafe-reports/*.xml' 
                }
            }
        }
        stage('Install') {
            steps {
                sh "mvn -B -DskipTests -DskipITs install -Dcargo.hostname=${hostname} -Dcargo.protocol=${protocol} -Dcargo.port=${port} -Dcargo.user=${user} -Dcargo.pass=${pass}"
            }
        }
        
    }
}
