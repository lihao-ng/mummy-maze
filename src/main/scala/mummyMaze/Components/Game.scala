package Components

import java.io.File
import java.util.{Timer, TimerTask}

import mummyMaze.Main
import scalafx.scene._
import scalafx.scene.input._
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.scene.control.{Button, Label, SplitPane}
import scalafx.scene.image.{Image, ImageView}
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
          print("Stop")
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
      style = "-fx-background-color: #d89b31;"
      children = List(
        new ImageView(new Image(new File("src/main/resources/mummyMaze/images/title/logo.png").toURI.toURL.toString)) {
          x = 15.0
          y = 20.0
          fitWidth = 270.0
          fitHeight = 170.0
        },
        new ImageView(new Image(new File("src/main/resources/mummyMaze/images/title/score.png").toURI.toURL.toString)) {
          x = 70.0
          y = 290.0
          fitWidth = 170.0
          fitHeight = 80.0
        },
        new Label("LEVEL " + currentLevel) {
          prefWidth = 300.0
          prefHeight = 60.0
          layoutX = 0.0
          layoutY = 200.0
          style = "-fx-font-family: 'COOPER BLACK'; -fx-wrap-text: true; -fx-text-alignment: center; -fx-font-size: 60; -fx-font-weight: extra bold; -fx-alignment: center;"
        },
        new Label("1000") {
          prefWidth = 220.0
          prefHeight = 60.0
          layoutX = 40.0
          layoutY = 370.0
          style = "-fx-font-family: 'AR BERKLEY'; -fx-wrap-text:true; -fx-text-alignment: center; -fx-font-size: 60; -fx-font-weight: bold; -fx-alignment: center;"
        },
        new Button {
          style = " -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;"
          prefWidth = 40.0
          prefHeight = 100.0
          layoutX = 40.0
          layoutY = 450.0
          graphic = new ImageView(new Image(new File("src/main/resources/mummyMaze/images/button/back-icon.png").toURI.toURL.toString))
          onAction = () => Main.backHomePage()
        }
      )
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
    stopTimer(task)
  }
}
