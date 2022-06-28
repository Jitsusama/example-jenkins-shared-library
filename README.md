# Jenkins Shared Library Example

This repository shows a very simplistic example of developing a
simple [Jenkins Shared Library](https://www.jenkins.io/doc/book/pipeline/shared-libraries/) using
the [Gradle Build Tool](https://gradle.org/) and
the [Spock Testing Framework](https://spockframework.org/) to test drive its implementation. It
utilizes the [Jenkins Pipeline Unit](https://github.com/jenkinsci/JenkinsPipelineUnit) library to
mock out Jenkins itself so that tests can be properly insulated from the Jenkins environment.
