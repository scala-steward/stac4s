package com.azavea.stac4s.extensions.layer

import com.azavea.stac4s.meta._
import com.azavea.stac4s.{Bbox, StacLink}

import cats.kernel.Eq
import eu.timepit.refined.types.string
import geotrellis.vector.Geometry
import io.circe.refined._
import io.circe.{Decoder, Encoder}

final case class StacLayer(
    id: string.NonEmptyString,
    bbox: Bbox,
    geometry: Geometry,
    properties: StacLayerProperties,
    links: List[StacLink],
    _type: String = "Feature"
)

object StacLayer {
  implicit val eqStacLayer: Eq[StacLayer] = Eq.fromUniversalEquals

  implicit val encStacLayer: Encoder[StacLayer] = Encoder.forProduct6(
    "id",
    "bbox",
    "geometry",
    "properties",
    "links",
    "type"
  )(layer => (layer.id, layer.bbox, layer.geometry, layer.properties, layer.links, layer._type))

  implicit val decStacLayer: Decoder[StacLayer] = Decoder.forProduct6(
    "id",
    "bbox",
    "geometry",
    "properties",
    "links",
    "type"
  )(StacLayer.apply)
}
