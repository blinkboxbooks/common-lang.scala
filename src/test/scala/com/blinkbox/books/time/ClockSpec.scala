package com.blinkbox.books.time

import org.joda.time.{Duration, DateTimeZone, DateTime}
import org.scalatest.FlatSpec

class ClockSpec extends FlatSpec {

  "SystemClock" can "provide the current system time in UTC" in {
    val now = DateTime.now(DateTimeZone.UTC)
    val clockNow = SystemClock.now()
    assert(clockNow >= now && clockNow <= now + Duration.millis(100))
  }

  "StoppedClock" can "provide the time it was stopped at" in {
    val now = DateTime.now(DateTimeZone.UTC)
    val clock = StoppedClock(now)
    assert(clock.now() == now)
  }

}
