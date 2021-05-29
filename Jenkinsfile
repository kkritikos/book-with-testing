pipeline {
	parameters {
	    password(name: 'pass', defaultValue: 'kleo315/', description: 'A secret password')
	    string(name: 'hostname', defaultValue: '35.167.191.96', description: '')
	    string(name: 'port', defaultValue: '8080', description: '')
	    string(name: 'protocol', defaultValue: 'http', description: '')
	    string(name: 'user', defaultValue: 'tomcat', description: '')
	}
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test_Develop') {
        	when {
	            branch 'develop'
	        } 
            steps {	
                sh 'mvn verify -P tomcat8x' 
            }
            post {
                always {
                    junit 'book-functional-tests/target/failsafe-reports/*.xml' 
                }
            }
        }
        stage('Test_Theme') { 
            when {
	            branch 'theme'
	        }
            steps {	
                sh 'mvn verify -P tomcat8x' 
            }
            post {
                always {
                    junit 'book-functional-tests/target/failsafe-reports/*.xml'
                    sh 'git config -l' 
                }
            }
        }
        stage('Install') {
        	when {
	            branch 'develop'
	        }
            steps {
                sh "mvn -B -DskipTests -DskipITs install -Dcargo.hostname=${hostname} -Dcargo.protocol=${protocol} -Dcargo.servlet.port=${port} -Dcargo.remote.username=${user} -Dcargo.remote.password=${pass}"
            }
        }
        
    }
}
