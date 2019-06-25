package mummyMaze

import java.io.File

import Components.Game
import scalafx.application._
import scalafx.scene._
import scalafx.scene.input._
import scalafx.Includes._
import scalafx.scene.media.{Media, MediaPlayer}
import scalafx.scene.shape.Polyline

object Main extends JFXApp {
  val Width = 1017
  val Height = 748
  val polyline = Polyline(0, 0, 500, 0, 500, 500, 0, 500, 100, 0)

  val music = playMusic
  music.cycleCount = MediaPlayer.Indefinite
  music.play()

  stage = new JFXApp.PrimaryStage {
    title = "Mummy Maze"
    minWidth = Width
    maxWidth = Width
    minHeight = Height
    maxHeight = Height

    scene = loadMainMenu
}
  def loadMainMenu = {
    new Scene(Width, Height) {
      content = List(polyline)

      onKeyPressed = (e: KeyEvent) => {
        e.code match {
          case KeyCode.Left => {
            changeScreen
          }
          case _ =>
        }
      }
    }
  }

  def changeScreen = {
    val game = new Game()
    stage.scene = game.scene
  }

  def playMusic = {
    new MediaPlayer(new Media(new File("src/main/resources/mummyMaze/musics/background_music.wav").toURI.toURL.toString))
  }
}
