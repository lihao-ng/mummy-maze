package Components

import Maps.Map
import mummyMaze.Main
import scalafx.scene._
import scalafx.scene.input._
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.scene.control.SplitPane

class Game() {
  var keyLeft = false
  var keyRight = false
  var keyUp = false
  var keyDown = false

  var map = new Map(new Player, new Mummy, 1)
  var scene = createScene

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
      map = new Map(new Player, new Mummy, 2)
      scene = createScene
      Main.stage.scene = scene
    }
  }

  def createScene: Scene = {
    new Scene() {
      content = new SplitPane() {
        items.add(map.menuComponent)
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

      val timer = AnimationTimer(t => {
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

      timer.start()
    }
  }
}
