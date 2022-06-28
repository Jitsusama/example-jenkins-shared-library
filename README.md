# Jenkins Shared Library Example

This repository shows a very simplistic example of developing a
simple [Jenkins Shared Library](https://www.jenkins.io/doc/book/pipeline/shared-libraries/) using
the [Gradle Build Tool](https://gradle.org/) and the
[Spock Testing Framework](https://spockframework.org/) to test drive its implementation. It utilizes
the [Jenkins Pipeline Unit](https://github.com/jenkinsci/JenkinsPipelineUnit) library to
mock out Jenkins itself so that tests can be properly insulated from the Jenkins environment.

## Structure

The tests live in the [org.example.jenkins](./test/org/example/jenkins) package and can be run via
the Gradle :test task.

The exposed Jenkins library lives in the [vars](./vars) directory, with each module basename being
exposed by Jenkins as a new global variable when this repository is introduced to a pipeline via
the `@Library(...)` annotation. The files in this directory are the only ones evaluated by Jenkins.

The Gradle build configuration lives in [build.gradle](./build.gradle) and it brings in all of the
libraries required for running tests.

## Usage

To run the tests, you will want to configure your JAVA_HOME environment variable to point at a JDK
version 8/1.8.0 base directory, then you can run `./gradlew :test` (*NIX) or `.\gradlew.bat :test`
(Windows) to download the correct version of Gradle and to run the tests.

To use this library on a Jenkins installation, you will first need to configure Jenkins to expose
this repository as
a [Global Shared Library](https://www.jenkins.io/doc/book/pipeline/shared-libraries/#global-shared-libraries)
and then you can `@Library("<configured-name>")` in your pipeline to have the [vars](./vars) modules
exposed as globals within that pipeline. Reading Jenkins'
[Jenkins Shared Library](https://www.jenkins.io/doc/book/pipeline/shared-libraries/) docs will
provide a good overview of what this is all about.

