package com.blinkbox.books

import scala.language.implicitConversions

final case class Sensitive[A](value: A) {
  override def toString: String = "******"
}

object Sensitive {
  implicit def forAny[A](value: A): Sensitive[A] = Sensitive(value)
}
