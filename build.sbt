lazy val root = (project in file(".")).
  settings(
    name := "common-lang",
    organization := "com.blinkbox.books",
    version := scala.util.Try(scala.io.Source.fromFile("VERSION").mkString.trim).getOrElse("0.0.0"),
    scalaVersion := "2.11.4",
    crossScalaVersions := Seq("2.11.4"),
    scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8", "-target:jvm-1.7", "-Xfatal-warnings", "-Xfuture"),
    libraryDependencies ++= Seq(
      "joda-time"       %  "joda-time"        % "2.5",
      "org.joda"        %  "joda-convert"     % "1.7",
      "org.scalatest"   %% "scalatest"        % "2.2.2"   % Test,
      "junit"           %  "junit"            % "4.11"    % Test,
      "com.novocode"    %  "junit-interface"  % "0.11"    % Test
    )
  )
