pipeline {

  agent any

  options {
    timestamps()
  }

  tools {
    jdk 'JAVA_HOME'
    git 'GIT'
    allure 'ALLURE_HOME'
    maven 'MAVEN_HOME'
  }

  triggers {
    pollSCM('* 1 * 1 *')
  }

  parameters {
    booleanParam defaultValue: false, description: 'If you want clean report', name: 'wantToCopyResultFromPreviousBuild'
    choice choices: ['chrome', 'firefox', 'ie'], description: 'select browser', name: 'browser'
    string defaultValue: '@scroll', description: 'select tag & it will trigger', name: 'tags', trim: true
    string defaultValue: 'master', description: 'select git branch', name: 'GIT_BRANCH', trim: true
    choice choices: ['QA', 'PROD', 'STAGE'], description: 'select Env', name: 'Env'
    string name: 'BRANCH', defaultValue: 'master', description: 'Git branch to build'
  }

  stages {
    stage('Display on UI') {
      steps {
        script {
          currentBuild.description = 'Branch: ' + params.BRANCH
          currentBuild.description += '\nEnv: ' + params.Env
          currentBuild.description += '\nTags: ' + params.tags
        }
      }
    }

    stage('Checkout') {
      steps {
        echo "Checkout: ${params.PT_BRANCH}"
        git changelog: false, credentialsId: '36de9ea3-0d13-4f2a-aef1-4748c8333f2b', url: 'https://github.com/harshvegada/Playwright_Cucumber.git'
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

    stage('Mail') {
      steps {
        bat 'echo "Dropping email to audience"'
      }
    }
  }
}


