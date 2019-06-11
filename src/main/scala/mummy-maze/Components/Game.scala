package Components

import Maps.Map
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

  val map = new Map()

  val player = new Player(map)
  val mummy = new Mummy(map)

  val scene = new Scene() {
    content = new SplitPane() {
      items.add(map.menuComponent)
      items.add(map.wallComponent(player, mummy))
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
        player.moveLeft
        playerMove
      }

      if(keyRight) {
        player.moveRight
        playerMove
      }

      if(keyDown) {
        player.moveDown
        playerMove
      }

      if(keyUp) {
        player.moveUp
        playerMove
      }
    })

    timer.start()
  }

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
    mummy.track(player, mummy, map)
    if(player.haveDied(player, mummy)) println("Game Over!")
  }
}
