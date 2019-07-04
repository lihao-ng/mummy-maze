package ch.makery.address.Components

import scalafx.scene.image.Image
import java.io.File

import ch.makery.address.Main
import ch.makery.address.Traits.TrackMovement

class Mummy() extends Character with TrackMovement {
  x = Mummy.posX
  y = Mummy.posY
  fitWidth = Mummy.width
  fitHeight = Mummy.height
  image = Mummy.imageLeft
}

object Mummy {
  val posX = 340
  val posY = 445
  val width = 55
  val height = 55
  val step = 3
  val imageLeft = new Image(Main.getClass.getResource("images/mummy/mummy_left.png").toString)
  val imageRight = new Image(Main.getClass.getResource("images/mummy/mummy_right.png").toString)
}
