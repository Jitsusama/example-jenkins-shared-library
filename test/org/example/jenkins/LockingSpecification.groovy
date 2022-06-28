package org.example.jenkins

class LockingSpecification extends JenkinsSpecificationBase {
  def "runs block after setup"() {
    def sh = Mock(Closure)
    def block = Mock(Closure)

    given: "sh requests are mocked"
    helper.registerAllowedMethod("sh", [Map]) { sh(it) }

    when: "a block is passed to run after some setup"
    loadScript("vars/run.groovy").after(setup: "echo hello") {
      block()
    }

    then: "the setup command should be run"
    1 * sh(script: "echo hello")

    then: "the block should be run"
    1 * block()
  }
}
