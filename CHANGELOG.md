# Change log

## 0.2.1 ([#3](https://git.mobcastdev.com/Platform/common-lang/pull/3) 2014-11-24 14:37:10)

Updated dependencies

### Improvements

- Updated version dependencies
- Changed SBT file to multi-project style
- Now only supports scala 2.11

## 0.2.0 ([#2](https://git.mobcastdev.com/Platform/common-lang/pull/2) 2014-09-10 10:25:07)

Added some Joda time helpers

Moved some of the time support code from the auth service into a common
library.

### New features

- Provides a `Clock` interface to give access to time, plus some
concrete instances. Also has a `TimeSupport` trait to allow objects to
declare a time dependency.

## 0.1.0 ([#1](https://git.mobcastdev.com/Platform/common-lang/pull/1) 2014-09-05 11:24:37)

Added JAR manifest reader

### New features

- Added `JarManifest` for extracting data from jar manifests more easily.

