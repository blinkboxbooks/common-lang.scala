name := "common-lang"

organization := "com.blinkbox.books"

version := scala.util.Try(scala.io.Source.fromFile("VERSION").mkString.trim).getOrElse("0.0.0")

crossScalaVersions := Seq("2.10.4", "2.11.2")

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8", "-target:jvm-1.7")

libraryDependencies ++= Seq(
  "org.scalatest"   %% "scalatest"        % "2.2.2"   % Test,
  "junit"           %  "junit"            % "4.11"    % Test,
  "com.novocode"    %  "junit-interface"  % "0.11"    % Test
)