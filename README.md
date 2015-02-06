sutil-version
=============

sutil-version is just a small library of utilities for working with version strings not found (by the author) in other packages, written in the scala programming language, such as...

A set of classes to parse and match version strings in "common" formats.

Classes modeling version strings and its components:

```scala
Version(VersionNumber(2, 1), VersionModifier("beta", VersionNumber(5)))   // version "2.1-beta5"
```

with shorthand synonyms:

```scala
V(N(2, 1), M("beta", N(5)))   // version "2.1-beta5"
```

A Version can have n version modifiers:

```scala
V(N(2, 1), M("beta", N(5)), M("ubuntu", N(1)))   // version "2.1-beta5-ubuntu1"
```

Nice version parsing from strings:

```scala
Version("4.1.2-beta2-ubuntu1") == V(N(4, 1, 2), M("beta", N(2)), M("ubuntu", N(1)))
```

and the other way aroung using "toString":

```scala
V(N(4, 1, 2), M("beta", N(2)), M("ubuntu", N(1))).toString == "4.1.2-beta2-ubuntu1"
```

All three Version, VersionNumber and VersionModifier implements Ordered, so it gets useful:

```scala
Seq[Version]("3-sp4", "1", "1.0", "1.1", "2", "0.1", "2-snapshot", "3").sorted
  // returns Seq[Version]("0.1", "1", "1.0", "1.1", "2-snapshot", "2", "3", "3-sp4")
```

(there's an implicit conversion from String to Version inplace).

Version modifier tags compare impl knows some "common" (case insensitive) version tags:

```scala
Seq[VersionModifier]("beta2", "Final", "ALPHA3", "sp2", "snapshot", "cr1", "beta").sorted
  // returns Seq[VersionModifier]("snapshot", "ALPHA3", "beta", "beta2", "cr1", "Final", "sp2")
```

And there's a Version Range too:

```scala
V("2.1") to V("3.0") contains V("2.5-beta2")            // evaluates to true
V("2.1") until V("3.0") contains V("3.0")               // evaluates to false
V("2.1") until V("3.0") contains V("3.0-snapshot")      // evaluates to true (tricky!)
```

(version and versionnumber ranges are not traversable since they are continuous).

Version number increments:

```scala
VersionNumber(2,1) increment Major == VersionNumber(3,1)
VersionNumber(2,1) increment Fix == VersionNumber(2,1,1)
VersionNumber(2,1) incrementAt 5 == VersionNumber(2,1,0,0,0,1)
VersionNumber(2,1) incrementBy VersionNumber(0,1,1) == VersionNumber(2,2,1)
```
