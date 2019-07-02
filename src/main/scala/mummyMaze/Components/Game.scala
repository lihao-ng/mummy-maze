package mummyMaze.Components

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
  var task: TimerTask = loadBonusTimer()

  var scene: Scene = createScene
  var animationTimer: AnimationTimer = createAnimationTimer
  animationTimer.start()

  def loadBonusTimer(): TimerTask = {
    val task = new TimerTask {
      def run(): Unit = {
        println(bonusTime)
        if(bonusTime >= 40) {
          stopTimer(bonusTimer, this)
        }else {
          bonusTime += 1
        }
      }
    }

    bonusTimer.schedule(task, 1000, 1000)
    task
  }

  def stopTimer(bonusTimer: Timer, task: TimerTask): Boolean = {
    bonusTimer.cancel()
    task.cancel()
  }

  def createScene(): Scene = {
    new Scene() {
      content = new SplitPane() {
        items.add(menuComponent)
        items.add(map.wallComponent())
        setDividerPosition(0, 0.3)
        prefWidth = 1000
        prefHeight = 700
      }

      onKeyPressed = (e:KeyEvent) => {
        keyValues(e, condition = true)
      }

      onKeyReleased = (e:KeyEvent) => {
        keyValues(e, condition = false)
      }
    }
  }

  def menuComponent: AnchorPane = {
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
          y = 270.0
          fitWidth = 170.0
          fitHeight = 80.0
        },
        new Label("LEVEL " + currentLevel) {
          prefWidth = 300.0
          prefHeight = 60.0
          layoutX = 0.0
          layoutY = 190.0
          style = "-fx-font-family: 'COOPER BLACK'; -fx-wrap-text: true; -fx-text-alignment: center; -fx-font-size: 60; -fx-font-weight: bold; -fx-alignment: center;"
        },
        new Label(currentScore.v.value.toString) {
          prefWidth = 220.0
          prefHeight = 60.0
          layoutX = 40.0
          layoutY = 340.0
          style = "-fx-font-family: 'AR BERKLEY'; -fx-wrap-text:true; -fx-text-alignment: center; -fx-font-size: 60; -fx-font-weight: bold; -fx-alignment: center;"
        },
        new Button {
          style = " -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;"
          prefWidth = 40.0
          prefHeight = 80.0
          layoutX = 40.0
          layoutY = 420.0
          graphic = new ImageView(new Image(new File("src/main/resources/mummyMaze/images/button/back-icon.png").toURI.toURL.toString))
          onAction = () => {
            stopTimer(bonusTimer, task)
            Main.backHomePage()
          }
        }
      )
    }
  }

  def createAnimationTimer: AnimationTimer = {
    AnimationTimer(t => {
      if(keyLeft) {
        map.player.moveLeft(map.walls)
        playerMove()
      }

      if(keyRight) {
        map.player.moveRight(map.walls)
        playerMove()
      }

      if(keyDown) {
        map.player.moveDown(map.walls)
        playerMove()
      }

      if(keyUp) {
        map.player.moveUp(map.walls)
        playerMove()
      }
    })
  }

  def keyValues(e: KeyEvent, condition: Boolean): Unit = {
    e.code match {
      case KeyCode.Left => keyLeft = condition
      case KeyCode.Right => keyRight = condition
      case KeyCode.Up => keyUp = condition
      case KeyCode.Down => keyDown = condition
      case _ =>
    }
  }

  def playerMove(): Unit = {
    map.mummy.track(map.player, map.mummy, map.walls, map.exit)

    if(map.player.haveDied(map.player, map.mummy)) {
      println("GAME OVER!")
    }else if(map.player.haveCollideExit(map.exit)) {
      currentLevel += 1
      switchLevel()
    }
  }

  def switchLevel(): Unit = {
    if(currentLevel <= Map.levels.length) {
      getScore()
      map = new Map(new Player, new Mummy, currentLevel)
      Main.stage.scene = createScene()
    } else {
      stopTimer(bonusTimer, task)
      Main.stage.scene = Main.loadMainMenu
    }
  }

  def getScore(): Unit = {
    val currentValue = currentScore.v.value
    var bonusScore = 0

    bonusTime match {
      case x if x <= 10 => bonusScore = 30
      case x if x <= 20 => bonusScore = 20
      case x if x <= 30 => bonusScore = 10
      case _=> bonusScore = 0
    }

    currentScore = new Score(currentValue + bonusScore + 50)

    stopTimer(bonusTimer, task)
    bonusTime = 1
    bonusTimer = new Timer()
    task = loadBonusTimer()
  }
}
