name := "mummy-maze"

version := "0.1"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "8.0.181-R13",
  "org.scalafx" %% "scalafxml-core-sfx8" % "0.4",
  "org.apache.derby" % "derby" % "10.14.2.0",
  "org.scalikejdbc" %% "scalikejdbc"       % "3.3.5",
  "com.h2database"  %  "h2"                % "1.4.199",
  "ch.qos.logback"  %  "logback-classic"   % "1.2.3"

)