package Components

import scalafx.scene.image.Image
import java.io.File

import Traits.{Death, KeyMovement, Win}
import scalafx.scene.shape.Rectangle

class Player() extends Character with KeyMovement with Win with Death {
  x = Player.x
  y = Player.y
  fitWidth = Player.width
  fitHeight = Player.height
  image = Player.imageRight

   def moveLeft(walls: List[Rectangle]) = {
    image = Player.imageLeft
    this.x.value -= Player.step
    if (!wallCollide(walls)) this.x.value += Player.step
  }

  def moveRight(walls: List[Rectangle]) = {
    image = Player.imageRight
    this.x.value += Player.step
    if (!wallCollide(walls)) this.x.value -= Player.step
  }

  def moveUp(walls: List[Rectangle]) = {
    this.y.value -= Player.step
    if (!wallCollide(walls)) this.y.value += Player.step
  }

  def moveDown(walls: List[Rectangle]) = {
    this.y.value += Player.step
    if (!wallCollide(walls)) this.y.value -= Player.step
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
