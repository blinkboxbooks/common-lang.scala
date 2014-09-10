package com.blinkbox.books

import org.joda.time.{ReadableDuration, ReadableInstant, DateTime}

package object time {
  
  implicit class DateTimeOps(val dt: DateTime) extends AnyVal {
    def >(instant: ReadableInstant) = dt.isAfter(instant)
    def >=(instant: ReadableInstant) = !dt.isBefore(instant)
    def <(instant: ReadableInstant) = dt.isBefore(instant)
    def <=(instant: ReadableInstant) = !dt.isAfter(instant)
    def +(duration: ReadableDuration) = dt.plus(duration)
    def -(duration: ReadableDuration) = dt.minus(duration)
  }

}
