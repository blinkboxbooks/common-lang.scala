package com.blinkbox.books.time

import org.joda.time.{DateTime, DateTimeZone}
import org.scalatest.FlatSpec

class ClockSpec extends FlatSpec {

  "SystemClock" can "provide the current system time in UTC" in {
    val now = DateTime.now(DateTimeZone.UTC)
    val clockNow = SystemClock.now()
    assert(clockNow.getZone == DateTimeZone.UTC)
    assert(!clockNow.isBefore(now) && !clockNow.isAfter(now.plusMillis(100)))
  }

  "StoppedClock" can "provide the time it was stopped at" in {
    val now = DateTime.now(DateTimeZone.UTC)
    val clock = StoppedClock(now)
    assert(clock.now() == now)
  }

}
