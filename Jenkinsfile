pipeline {
    agent any
	environment {
		imagename = 'zirtrex/deisw-spring-onewebs'
		container = ' '
		//releasedVersion = getReleasedVersion()
	}
	tools {
        maven 'Maven 3.6.2'
        jdk 'Java 11'
    }
    stages {
        stage ('1-Verificar SCM') {
            steps {
                 echo 'Pulling...' + env.BRANCH_NAME
                 checkout scm
            }
        }
        stage ('2-Limpiar workspace') {
            steps {
                powershell 'mvn clean'
            }
        }
		stage ('3-Ejecutar Pruebas Unitarias') {
			steps {
				powershell 'mvn test -Dtest="pe.edu.upc.onewebs.unit.controller.*Test"'
			}
		}
		stage ('4-jecutar Pruebas de Integracion') {
            steps {
                powershell 'mvn test -Dtest="pe.edu.upc.onewebs.integration.*Test"'
            }
        }
        stage ('5-Ejecutar Spring Boot y Selenium') {
            steps {
                powershell 'mvn test -Dtest="pe.edu.upc.onewebs.ui.CrearUsuarioTest"'
            }
        }
        stage ('6-Ejecutar Sonar') {
            steps {
                powershell 'mvn jacoco:prepare-agent jacoco:report verify sonar:sonar -D sonar.login=df0bdafc803e3c1f1f2ea32064fbb4192c881d4d'
            }
        }
        stage ('7-Detener java') {
            steps {
                powershell 'wmic Path win32_process Where "CommandLine Like \'%onewebs-1.0.jar%\'" Call Terminate'
            }
        }
    }
    post {
        always {
            echo 'Hola desde Jenkins!'
        }
		success {
		    echo 'Todo bien!'
		}
		failure {
		    echo 'Falla!'
		}
    }
}
def getReleasedVersion() {
	return (readFile('pom.xml') =~ '<version>(.+)-SNAPSHOT</version>')[0][1]
}