package Maps

import java.io.File

import Components.{Mummy, Player}
import scalafx.scene.Group
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.AnchorPane
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

class Map(val player: Player, val mummy: Mummy, val level: Int) {
    val walls = getStage
    val img = new Image(new File("src/main/resources/mummyMaze/images/background/background.jpg").toURI.toURL.toString)
    val view = new ImageView(img)
    view.fitWidth = 700.0
    view.fitHeight = 700.0

    val exit = Rectangle (0.0, 598.0, 35.0, 67.0)
    exit.fill = Color.Aqua

    val stage = new Group {
      children = walls
    }

    def wallComponent() = {
      new AnchorPane {
        children = new Group(view, stage, exit, player, mummy)
      }
    }

    def menuComponent = {
      new AnchorPane()
    }

  def getStage = {
    if(level == 1) {
      Stage1.walls
    }else {
      Stage2.walls
    }
  }
}
