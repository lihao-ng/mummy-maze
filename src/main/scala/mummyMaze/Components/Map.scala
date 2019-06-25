package Components

import java.io.File

import Maps.{Level1, Level2, Level3}
import scalafx.scene.{Group}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.AnchorPane

class Map(val player: Player, val mummy: Mummy, val level: Int) {
  var walls = loadLevel
  val exit = new ImageView(new Image(new File("src/main/resources/mummyMaze/images/background/background.jpg").toURI.toURL.toString))
  exit.fitWidth = 35.0
  exit.fitHeight = 67.0
  exit.setX(0.0)
  exit.setY(598.0)

  val stage = new Group {
    children = walls
  }

  def wallComponent() = {
    new AnchorPane {
      style = "-fx-background-color: brown"
      children = new Group(stage, exit, player, mummy)
    }
  }

  def loadLevel= {
    Map.levels(level - 1)
  }
}

object Map {
  val levels = Array(Level1.walls, Level2.walls, Level3.walls)
}