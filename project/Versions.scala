import sbt._
import sbt.Keys._

object Versions {

  private def ver(for212: String, for213: String) = Def.setting {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, 12)) => for212
      case Some((2, 13)) => for213
      case _             => sys.error("not good")
    }
  }

  val Cats                    = "2.7.0"
  val Circe                   = "0.14.1"
  val CirceJsonSchema         = "0.2.0"
  val DisciplineScalatest     = "2.1.5"
  val Enumeratum              = "1.7.0"
  val GeoTrellis              = "3.6.2"
  val Jts                     = "1.18.1"
  val Monocle                 = "2.1.0"
  val Refined                 = "0.9.28"
  val ScalacheckCats          = "0.3.1"
  val Scalacheck              = "1.16.0"
  val ScalatestPlusScalacheck = "3.2.2.0"
  val Scalatest               = "3.2.11"
  val Scapegoat               = "1.4.12"
  val Shapeless               = "2.3.7"
  val Sttp                    = "3.5.2"
  val SttpModel               = "1.4.25"
  val SttpShared              = "1.3.5"
  val Fs2                     = "2.5.10"
  val ThreeTenExtra           = "1.7.0"
}
