package com.blinkbox.books.jar

import org.scalatest.FlatSpec

class JarManifestSpec extends FlatSpec {

  "JarManifest" can "load a valid manifest file" in {
    testManifest
  }

  it can "extract the implementation title" in {
    assert(testManifest.implementationTitle == Some("auth-service-public"))
  }

  it can "extract the implementation version" in {
    assert(testManifest.implementationVersion == Some("0.17.4"))
  }

  it can "return no manifest when the code is not compiled into a jar" in {
    assert(JarManifest.blinkboxDefault == None)
  }

  private def testManifest = new JarManifest(getClass.getClassLoader.getResourceAsStream("MANIFEST.MF"))
}
