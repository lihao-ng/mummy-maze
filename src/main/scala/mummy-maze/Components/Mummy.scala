package Components

import scalafx.scene.image.Image
import java.io.File

import Maps.Map
import Traits.TrackMovement

class Mummy(val map: Map) extends Character with TrackMovement {
  x = Mummy.x
  y = Mummy.y
  fitWidth = Mummy.width
  fitHeight = Mummy.height
  image = Mummy.imageLeft

//  def moveLeft = {
//    image = Mummy.imageLeft
//    this.x.value -= Mummy.xStep
//    if (!wallCollide(map)) this.x.value += Mummy.xStep
//  }
//  def moveRight = {
//    image = Mummy.imageRight
//    this.x.value += Mummy.xStep
//    if (!wallCollide(map)) this.x.value -= Mummy.xStep
//  }
//
//  def moveUp = {
//    this.y.value -= Mummy.yStep
//    if (!wallCollide(map)) this.y.value += Mummy.yStep
//  }
//  def moveDown = {
//    this.y.value += Mummy.yStep
//    if (!wallCollide(map)) this.y.value -= Mummy.yStep
//  }
}

object Mummy {
//  635,350
  val x = 340
  val y = 445
  val width = 55
  val height = 55
  val step = 4
  val imageLeft = new Image(new File("src/main/resources/mummy-maze/images/mummy/mummy_left.png").toURI.toURL.toString)
  val imageRight = new Image(new File("src/main/resources/mummy-maze/images/mummy/mummy_right.png").toURI.toURL.toString)
}
