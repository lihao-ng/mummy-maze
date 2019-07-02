package mummyMaze.Components

import java.io.File

import mummyMaze.Levels.Levels
import scalafx.scene.Group
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.AnchorPane
import scalafx.scene.shape.Rectangle

class Map(val player: Player, val mummy: Mummy, val level: Int) {
  var walls = loadLevel()
  val exit = new ImageView(new Image(new File("src/main/resources/mummyMaze/images/background/background.jpg").toURI.toURL.toString))
  exit.fitWidth = 35.0
  exit.fitHeight = 67.0
  exit.setX(0.0)
  exit.setY(598.0)

  val view = new ImageView(new Image(new File("src/main/resources/mummyMaze/images/background/background2.png").toURI.toURL.toString)){
    fitWidth = 700.0
    fitHeight = 700.0
  }

  val stage = new Group {
    children = walls
  }

  def wallComponent(): AnchorPane = {
    new AnchorPane {
      children = new Group(view, stage, exit, player, mummy)
    }
  }

  def loadLevel(): List[Rectangle] = {
    Map.levels(level - 1)
  }
}

object Map {
  val levels = Array(Levels.level1, Levels.level2, Levels.level3)
}