package com.blinkbox.books.jar

import java.io.InputStream
import java.util.jar.Manifest

import scala.collection.JavaConverters._

class JarManifest(input: InputStream) {
  private val manifest =
    try new Manifest(input)
    finally input.close()

  lazy val implementationTitle = Option(manifest.getMainAttributes.getValue("Implementation-Title"))
  lazy val implementationVendor = Option(manifest.getMainAttributes.getValue("Implementation-Vendor"))
  lazy val implementationVersion = Option(manifest.getMainAttributes.getValue("Implementation-Version"))

  lazy val implementationVendorIsBlinkbox = implementationVendor.fold(false)(_.startsWith("com.blinkbox"))
}

object JarManifest {
  /**
   * Returns the default blinkbox manifest in the current context.
   *
   * If there are either zero manifests, or multiple manifests, then this returns `None` so it is recommended
   * for use only when the application is packaged as a fat jar with all dependencies bundled.
   */
  lazy val blinkboxDefault: Option[JarManifest] = {
    val manifests = getClass.getClassLoader.getResources("META-INF/MANIFEST.MF").asScala.map(u => new JarManifest(u.openStream))
    manifests.filter(_.implementationVendorIsBlinkbox).toList match {
      case manifest :: Nil => Some(manifest)
      case _ => None
    }
  }
}
