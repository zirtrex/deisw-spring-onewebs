pipeline {
    agent any
	
	environment {
		imagename = 'zirtrex/deisw-spring-onewebs'
		container = 'onewebs'
		//releasedVersion = getReleasedVersion()
	}

	tools {
        maven 'Maven 3.6.2'
        jdk 'jdk11'
    }
	
    stages {
        stage('Verificar SCM') {
            steps {
                 echo 'Pulling...' + env.BRANCH_NAME
                 checkout scm
            }
        }
		stage('Ejecutar Pruebas Unitarias'){
			steps {
				powershell 'mvn clean'
				powershell 'mvn test -Dtest="pe.edu.upc.onewebs.controller.StarterControllerTest"'
			}
		}
		stage('Compilar Paquete'){
			steps {
				powershell 'mvn clean package'
			}
		}
    }
	
    post {
        always {
            echo 'Hola!'
        }
		success {
		    echo 'Todo bien!'
		}
		failure {
		    echo 'Falla!'
		}
    }
}

def dockerCmd(args) {
	powershell "docker ${args}"
}

def getReleasedVersion() {
	return (readFile('pom.xml') =~ '<version>(.+)-SNAPSHOT</version>')[0][1]
}	
