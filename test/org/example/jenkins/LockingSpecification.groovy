package org.example.jenkins

/**
 * This example test class extends {@link org.example.jenkins.SpecificationBase} so that it can
 * serve as a Spock test fixture for testing Jenkins Shared Library code.
 */
class LockingSpecification extends SpecificationBase {
  def "runs block after setup"() {
    def sh = Mock(Closure)
    def block = Mock(Closure)

    // using helper.registerAllowedMethod you can stub/mock out internal Jenkins steps
    given: "sh requests are mocked"
    helper.registerAllowedMethod("sh", [Map]) { sh(it) }

    // using loadScript, you can load a var module and access globals it exposes
    when: "a block is passed to run after some setup"
    loadScript("vars/run.groovy").after(setup: "echo hello") {
      block()
    }

    // since we mocked out the sh command, we can use Spock to validate it was called correctly
    then: "the setup command should be run"
    1 * sh(script: "echo hello")

    then: "the block should be run"
    1 * block()
  }
}
