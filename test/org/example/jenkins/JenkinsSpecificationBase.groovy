package org.example.jenkins

import com.lesfurets.jenkins.unit.BasePipelineTest
import spock.lang.Specification

/**
 * This class serves as a base class for your own test specifications. This allows your
 * specification to run within Spock while also having the Jenkins Unit library methods
 * exposed within your specification fixture.
 */
class JenkinsSpecificationBase extends Specification {
  @Delegate
  BasePipelineTest basePipelineTest

  @SuppressWarnings('unused')
  def setup() {
    basePipelineTest = new BasePipelineTest() {}
    basePipelineTest.setUp()
  }
}
