package ch.makery.address.Components

import scalafx.scene.image.Image
import java.io.File

import ch.makery.address.Main
import ch.makery.address.Traits.{Death, KeyMovement}
import scalafx.scene.shape.Rectangle

class Player() extends Character with KeyMovement with Death {
  x = Player.posX
  y = Player.posY
  fitWidth = Player.width
  fitHeight = Player.height
  image = Player.imageRight

   def moveLeft(walls: List[Rectangle]): Unit = {
    image = Player.imageLeft
    this.x.value -= Player.step
    if (!noWallCollision(walls)) this.x.value += Player.step
  }

  def moveRight(walls: List[Rectangle]): Unit = {
    image = Player.imageRight
    this.x.value += Player.step
    if (!noWallCollision(walls)) this.x.value -= Player.step
  }

  def moveUp(walls: List[Rectangle]): Unit = {
    this.y.value -= Player.step
    if (!noWallCollision(walls)) this.y.value += Player.step
  }

  def moveDown(walls: List[Rectangle]): Unit = {
    this.y.value += Player.step
    if (!noWallCollision(walls)) this.y.value -= Player.step
  }
}

object Player {
  val posX = 370
  val posY = 150
  val width = 55
  val height = 55
  val step = 4
  val imageLeft = new Image(Main.getClass.getResource("images/player/player_left.png").toString)
  val imageRight = new Image(Main.getClass.getResource("images/player/player_right.png").toString)
}
