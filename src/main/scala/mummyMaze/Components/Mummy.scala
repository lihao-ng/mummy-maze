package Components

import scalafx.scene.image.{Image, ImageView}
import java.io.File

import Traits.TrackMovement

class Mummy() extends Character with TrackMovement {
  x = Mummy.x
  y = Mummy.y
  fitWidth = Mummy.width
  fitHeight = Mummy.height
  image = Mummy.imageLeft
}

object Mummy {
  val x = 340
  val y = 445
  val width = 55
  val height = 55
  val step = 3
  val imageLeft = new Image(new File("src/main/resources/mummyMaze/images/mummy/mummy_left.png").toURI.toURL.toString)
  val imageRight = new Image(new File("src/main/resources/mummyMaze/images/mummy/mummy_right.png").toURI.toURL.toString)
}
