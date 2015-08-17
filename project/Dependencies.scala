import sbt._

object Version {
  val hadoop    = "2.6.0"
  val logback   = "1.1.2"
  val mockito   = "1.10.19"
  val scala     = "2.11.7"
  val scalaTest = "2.2.4"
  val slf4j     = "1.7.6"
  val spark     = "1.4.1"
}

object Library {
  val hadoopClient   = "org.apache.hadoop" %  "hadoop-client"   % Version.hadoop
  val logbackClassic = "ch.qos.logback"    %  "logback-classic" % Version.logback
  val mockitoAll     = "org.mockito"       %  "mockito-all"     % Version.mockito
  val scalaTest      = "org.scalatest"     %% "scalatest"       % Version.scalaTest
  val slf4jApi       = "org.slf4j"         %  "slf4j-api"       % Version.slf4j
  val sparkSQL       = "org.apache.spark"  %% "spark-sql" % Version.spark
}

object Dependencies {
  import Library._

  val sparkAkkaHadoop = Seq(
    sparkSQL,
//    hadoopClient,
    logbackClassic % "test",
    scalaTest      % "test",
    mockitoAll     % "test"
  )
}
