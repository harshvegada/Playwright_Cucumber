pipeline {

  agent any

  options {
    timestamps()
  }

  tools {
    jdk 'JAVA_HOME'
    git 'GIT'
    maven 'MAVEN_HOME'
  }
  
  parameters {
    booleanParam defaultValue: false, description: 'If you want clean report', name: 'wantToCopyResultFromPreviousBuild'
    choice choices: ['chrome', 'firefox', 'ie'], description: 'select browser', name: 'browser'
    string defaultValue: '@scroll', description: 'select tag & it will trigger', name: 'tags', trim: true
    string defaultValue: 'master', description: 'select git branch', name: 'GIT_BRANCH', trim: true
    choice choices: ['QA', 'PROD', 'STAGE'], description: 'select Env', name: 'Env'
  }

  stages {
    stage('Display on UI') {
      steps {
        script {
          currentBuild.description = 'Branch: ' + params.GIT_BRANCH
          currentBuild.description += '\nEnv: ' + params.Env
          currentBuild.description += '\nTags: ' + params.tags
        }
      }
    }

 stage('Checkout') {
       steps {
         echo "Checkout: ${params.GIT_BRANCH}"
         git branch: params.GIT_BRANCH, credentialsId: '36de9ea3-0d13-4f2a-aef1-4748c8333f2b', url: 'https://github.com/harshvegada/Playwright_Cucumber.git'
       }
     }


    stage('Clean Target') {
      steps {
        bat 'echo "Cleaning tager folder"'
        bat 'mvn clean'
      }
    }

    stage('Building') {
      steps {
        bat 'echo "Building source code"'
        bat 'mvn compile'
      }
    }

    stage('Testing') {
      steps {
        bat 'echo "Running Test cases source code"'
        bat 'mvn test -Dtags=$tags'
      }
    }
  }
}
