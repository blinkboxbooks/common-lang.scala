package com.blinkbox.books

import org.scalatest.FlatSpec

class SensitiveSpec extends FlatSpec {

  "Sensitive[T]" should "return a masked string when toString is called" in {
    val s = Sensitive("a password!")
    assert(s.toString == "******")
  }

  it should "return the original value when required" in {
    val s = Sensitive("a password!")
    assert(s.value == "a password!")
  }

  it can "be implicitly constructed from any type" in {
    val s1: Sensitive[String] = "a password!"
    val s2: Sensitive[Array[Byte]] = Array[Byte](1, 2, 3, 4, 5)
    assert(s1 != null && s2 != null)
  }

  it can "extract sensitive values" in {
    Sensitive("a password!") match {
      case Sensitive(v) => assert(v == "a password!")
    }
  }

  it can "be compared to another sensitive value for equality" in {
    assert(Sensitive("a") == Sensitive("a"))
    assert(Sensitive("a") != Sensitive("b"))
  }

}
