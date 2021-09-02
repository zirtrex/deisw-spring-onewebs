pipeline {
    agent any
	
	environment {
		imagename = 'zirtrex/deisw-spring-onewebs'
		container = 'onewebs'
		releasedVersion = getReleasedVersion()		
	}
	
    stages {
        stage('Verificar SCM') {
            steps {
                git 'https://github.com/zirtrex/deisw-spring-onewebs'
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
