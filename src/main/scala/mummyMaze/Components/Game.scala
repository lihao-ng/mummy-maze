package Components

import mummyMaze.Main
import scalafx.scene._
import scalafx.scene.input._
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.scene.control.SplitPane
import scalafx.scene.layout.AnchorPane
import scalafx.scene.shape.Polyline

class Game() {
  val polyline = Polyline(0, 0, 500, 0, 500, 500, 0, 500, 100, 0)
  var keyLeft = false
  var keyRight = false
  var keyUp = false
  var keyDown = false
  var currentLevel = 1
  var map = new Map(new Player, new Mummy, currentLevel)
  var scene = createScene
  var timer = createTimer
  timer.start()

  def keyValues(e: KeyEvent, condition: Boolean) = {
    e.code match {
      case KeyCode.Left => keyLeft = condition
      case KeyCode.Right => keyRight = condition
      case KeyCode.Up => keyUp = condition
      case KeyCode.Down => keyDown = condition
      case _ =>
    }
  }

  def playerMove = {
    map.mummy.track(map.player, map.mummy, map.walls)

    if(map.player.haveDied(map.player, map.mummy)) {
      println("GAME OVER!")
    }else if(map.player.haveCollideExit(map.player, map.exit)) {
      currentLevel += 1
      switchLevel
    }
  }

  def createScene = {
    new Scene() {
      content = new SplitPane() {
        items.add(menuComponent)
        items.add(map.wallComponent)
        setDividerPosition(0, 0.3)
        prefWidth = 1000
        prefHeight = 700
      }

      onKeyPressed = (e:KeyEvent) => {
        keyValues(e, true)
      }

      onKeyReleased = (e:KeyEvent) => {
        keyValues(e, false)
      }
    }
  }

  def menuComponent = {
    new AnchorPane {
      minWidth = 300.0
    }
  }

  def createTimer = {
    AnimationTimer(t => {
      if(keyLeft) {
        map.player.moveLeft(map.walls)
        playerMove
      }

      if(keyRight) {
        map.player.moveRight(map.walls)
        playerMove
      }

      if(keyDown) {
        map.player.moveDown(map.walls)
        playerMove
      }

      if(keyUp) {
        map.player.moveUp(map.walls)
        playerMove
      }
    })
  }

  def switchLevel = {
    if(currentLevel <= Map.levels.length) {
      map = new Map(new Player, new Mummy, currentLevel)
      Main.stage.scene = createScene
    } else {
      Main.stage.scene = Main.loadMainMenu
    }
  }
}
