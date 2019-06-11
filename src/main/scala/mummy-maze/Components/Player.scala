package Components

import scalafx.scene.image.Image
import java.io.File

import Maps.Map
import Traits.{Death, KeyMovement, Win}

class Player(val map: Map) extends Character with KeyMovement with Win with Death {
  x = Player.x
  y = Player.y
  fitWidth = Player.width
  fitHeight = Player.height
  image = Player.imageRight

   def moveLeft() = {
    image = Player.imageLeft
    this.x.value -= Player.step
    if (!wallCollide(map)) this.x.value += Player.step
    haveCollideExit(this, map)
  }

  def moveRight = {
    image = Player.imageRight
    this.x.value += Player.step
    if (!wallCollide(map)) this.x.value -= Player.step
    haveCollideExit(this, map)
  }

  def moveUp = {
    this.y.value -= Player.step
    if (!wallCollide(map)) this.y.value += Player.step
    haveCollideExit(this, map)
  }

  def moveDown = {
    this.y.value += Player.step
    if (!wallCollide(map)) this.y.value -= Player.step
    haveCollideExit(this, map)
  }
}

object Player {
//  40
//  350
  val x = 370
  val y = 150
  val width = 55
  val height = 55
  val step = 4
  val imageLeft = new Image(new File("src/main/resources/mummy-maze/images/player/player_left.png").toURI.toURL.toString)
  val imageRight = new Image(new File("src/main/resources/mummy-maze/images/player/player_right.png").toURI.toURL.toString)
}
