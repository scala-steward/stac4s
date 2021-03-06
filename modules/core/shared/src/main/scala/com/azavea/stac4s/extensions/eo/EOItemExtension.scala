package com.azavea.stac4s.extensions.eo

import com.azavea.stac4s.extensions.ItemExtension

import cats.Eq
import cats.data.NonEmptyList
import io.circe._
import io.circe.refined._
import io.circe.syntax._

case class EOItemExtension(
    bands: NonEmptyList[Band],
    cloudCover: Option[Percentage]
)

object EOItemExtension {

  implicit val eq: Eq[EOItemExtension] = Eq.fromUniversalEquals

  implicit val encEOItemExtension: Encoder.AsObject[EOItemExtension] = Encoder
    .AsObject[Map[String, Json]]
    .contramapObject((band: EOItemExtension) =>
      Map("eo:bands" -> band.bands.asJson, "eo:cloud_cover" -> band.cloudCover.asJson)
    )
    .mapJsonObject(_.filter({ case (_, jValue) =>
      !jValue.isNull
    }))

  implicit val decEOItemExtension: Decoder[EOItemExtension] = Decoder.forProduct2(
    "eo:bands",
    "eo:cloud_cover"
  )(EOItemExtension.apply)

  implicit val itemExtension: ItemExtension[EOItemExtension] = ItemExtension.instance
}
