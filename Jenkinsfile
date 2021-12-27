pipeline
{
    agent any
    
    stages{
        stage("Build")
        {
            steps{
                echo("building the project")
            }
        }
    
        stage("Unit Test")
        {
            steps{
                echo("running unit test cases")
            }
        }
        stage("Deploy on DEV env")
        {
            steps{
                echo("deploying on DEV env")
            }
        }
        stage("Deploy on QA env")
        {
            steps{
                echo("deploying on QA env")
            }
        }
        stage("Sanity Test")
        {
            steps{
                echo("running sanity test cases")
            }
        }
        stage("Regression Test")
        {
            steps{
                echo("running Regression test cases on QA")
            }
        }
        stage("Deploy on Stage env")
        {
            steps{
                echo("deploying on Stage env")
            }
        }
        stage("Sanity Test on stage")
        {
            steps{
                echo("running sanity test cases on stage")
            }
        }
        stage("Deploy on PROD env")
        {
            steps{
                echo("deploying on PROD env")
            }
        }
    }
}