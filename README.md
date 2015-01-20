# common-lang

A core library providing functionality missing from system libraries.

## Information flow

Case classes to mark the [information flow][if] of data in the system:

- `Sensitive[A]` marks a value as containing sensitive information, e.g. [personally identifiable information][pii] and returns a masked value from `toString` helping to prevent inadvertent information leakage. Should be used for any property or parameter that contains sensitive information.

For example:

```scala
case class User(id: String, username: Sensitive[String], ...)
```

## Time

A `Clock` trait and associated classes `SystemClock` and `StoppedClock` which are useful for main and test code respectively. Also includes a `TimeSupport` trait to indicate dependence on time.

Note that when we transition to Java 8 the `java.time` package will supersede these classes and they should be deprecated.

## Jar Inspection

The `JarManifest` class allows you to look up values in the JAR manifest.



[if]: http://en.wikipedia.org/wiki/Information_flow_%28information_theory%29 "Information flow (information theory)"
[pii]: http://en.wikipedia.org/wiki/Personally_identifiable_information "Personally identifiable information"
