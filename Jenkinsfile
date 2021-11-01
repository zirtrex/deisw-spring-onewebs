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
		stage ('2-Ejecutar Pruebas Unitarias') {
			steps {
				powershell 'mvn clean'
				powershell 'mvn test -Dtest="pe.edu.upc.onewebs.unit.controller.*Test"'
			}
		}
		stage ('3-jecutar Pruebas de Integracion') {
            steps {
                powershell 'mvn clean'
                powershell 'mvn test -Dtest="pe.edu.upc.onewebs.integration.*Test"'
            }
        }
        stage ('4-Ejecutar Sonar') {
            steps {
                powershell 'mvn clean verify sonar:sonar -D sonar.login=df0bdafc803e3c1f1f2ea32064fbb4192c881d4d'
            }
        }
		stage ('5-Ejecutar Spring Boot') {
			steps {
				//powershell 'mvn spring-boot:run'
			}
		}
		stage ('6-Prueba de Aceptacion de usuario con Selenium') {
            steps {
                powershell 'mvn -Dtest="pe.edu.upc.onewebs.ui.NewSeleneseIT" surefire:test'
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
