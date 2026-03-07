pipeline {
    agent any

    triggers {
        // Use a single cron block with both schedules separated by a newline
        cron('''
            0 9 * * *
            0 15 * * *
        ''')
    }

    parameters {
        choice(name: 'RUNNER',
                choices: ['Junit4Runner', 'FailedRunner'],
                description: 'Manual selection (Scheduled builds auto-select based on time)')
    }

    stages {
        stage('Determine Runner') {
            steps {
                script {
                    // Logic to auto-select the runner based on the current hour (24-hour format)
                    def currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

                    if (currentHour == 9) {
                        env.SELECTED_RUNNER = "Junit4Runner"
                    } else if (currentHour == 15) {
                        env.SELECTED_RUNNER = "FailedRunner"
                    } else {
                        // If triggered manually or via GitHub push, use the parameter
                        env.SELECTED_RUNNER = params.RUNNER
                    }
                    echo "Executing Runner: ${env.SELECTED_RUNNER}"
                }
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                bat "mvn test -Dtest=${env.SELECTED_RUNNER}"
            }
        }
    }

    post {
        always {
            // allowEmptyResults: true prevents the build from failing if Maven skipped tests
            junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true

            // Archives HTML reports if they exist
            archiveArtifacts artifacts: 'target/*.html', allowEmptyArchive: true
        }
        success {
            emailext (
                    subject: "SUCCESS: ${env.SELECTED_RUNNER} [Build #${env.BUILD_NUMBER}]",
                    body: """<p>The build for <b>${env.SELECTED_RUNNER}</b> was successful.</p>
                         <p>View Report: <a href='${env.BUILD_URL}artifact/target/cucumber-report.html'>Cucumber HTML Report</a></p>""",
                    to: 'darshanmesta47@hotmail.com', // Your verified recipient
                    mimeType: 'text/html'
            )
        }
        failure {
            emailext (
                    subject: "FAILED: ${env.SELECTED_RUNNER} [Build #${env.BUILD_NUMBER}]",
                    body: """<p>The build for <b>${env.SELECTED_RUNNER}</b> failed.</p>
                         <p>Console Logs: <a href='${env.BUILD_URL}console'>View Logs</a></p>""",
                    to: 'darshanmesta47@hotmail.com',
                    mimeType: 'text/html'
            )
        }
    }
}