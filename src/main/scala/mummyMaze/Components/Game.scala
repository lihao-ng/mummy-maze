package Components

import java.util.{Timer, TimerTask}

import mummyMaze.Main
import scalafx.scene._
import scalafx.scene.input._
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.scene.control.SplitPane
import scalafx.scene.layout.AnchorPane

class Game() {
  var keyLeft = false
  var keyRight = false
  var keyUp = false
  var keyDown = false

  var currentLevel = 1
  var map = new Map(new Player, new Mummy, currentLevel)
  var currentScore = new Score(0)

  var bonusTime = 1
  var bonusTimer = new Timer()
  var task = loadBonusTimer()
  bonusTimer.schedule(task, 1000, 1000)

  var scene = createScene
  var timer = createTimer
  timer.start()

  def loadBonusTimer()= {
    new TimerTask {
      def run() = {
        println(bonusTime)
        if(bonusTime >= 40) {
          stopTimer(this)
        }else {
          bonusTime += 1
        }
      }
    }
  }

  def stopTimer(task: TimerTask) = {
    task.cancel()
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
    map.mummy.track(map.player, map.mummy, map.walls, map.exit)

    if(map.player.haveDied(map.player, map.mummy)) {
      println("GAME OVER!")
    }else if(map.player.haveCollideExit(map.exit)) {
      currentLevel += 1
      switchLevel
    }
  }

  def switchLevel = {
    if(currentLevel <= Map.levels.length) {
      getScore
      map = new Map(new Player, new Mummy, currentLevel)
      Main.stage.scene = createScene
    } else {
      stopTimer(task)
      Main.stage.scene = Main.loadMainMenu
    }
  }

  def getScore = {
    val currentValue = currentScore.v.value
    var bonusScore = 0

    bonusTime match {
      case x if x <= 10 => bonusScore = 30
      case x if x <= 20 => bonusScore = 20
      case x if x <= 30 => bonusScore = 10
      case _=> bonusScore = 0
    }

    currentScore = new Score(currentValue + bonusScore + 50)
    bonusTime = 1
    task = loadBonusTimer()
  }
}
