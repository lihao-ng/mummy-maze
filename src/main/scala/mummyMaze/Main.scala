package mummyMaze

import java.io.File

import Components.{Game, HighScoreRecord, Score}
import Database.Database
import scalafx.Includes._
import scalafx.scene.media.{Media, MediaPlayer}
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import javafx.{scene => jfxs}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.collections.ObservableBuffer


object Main extends JFXApp {

  Database.setupDB()
  val playersHighScore = new ObservableBuffer[HighScoreRecord]()

  playersHighScore ++= HighScoreRecord.getAllRecord
  playersHighScore.sort((s,t) => s.score.value.v.value > t.score.value.v.value)

  val rootResource = getClass.getResource("view/Main.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots = loader.getRoot[jfxs.layout.AnchorPane]

//  val music = playMusic
//  music.cycleCount = MediaPlayer.Indefinite
//  music.play()

  stage = new PrimaryStage {
    title = "MummyMaze"
    scene = loadMainMenu
  }

  def loadMainMenu = {
    new Scene {
      content = roots
    }
  }

  def changeScreen = {
    val game = new Game()
    stage.scene = game.scene
  }

  def playMusic = {
    new MediaPlayer(new Media(new File("src/main/resources/mummyMaze/musics/background_music.wav").toURI.toURL.toString))
  }

  def backHomePage():Unit ={
    val resource = getClass.getResource("view/Main.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots2 = loader.getRoot[jfxs.layout.AnchorPane]
    stage.scene().setRoot(roots2)
  }

  def viewHighScore():Unit ={
    val resource = getClass.getResource("view/HighScore.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots2 = loader.getRoot[jfxs.layout.AnchorPane]
    roots2.stylesheets = List(getClass.getResource("css/HighScorePage.css").toExternalForm)
    stage.scene().setRoot(roots2)
  }

  def startGame():Unit ={
    val resource = getClass.getResource("view/GameOver.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots2 = loader.getRoot[jfxs.layout.AnchorPane]
    roots2.stylesheets = List(getClass.getResource("css/GameOver.css").toExternalForm)
    stage.scene().setRoot(roots2)
//    val game = new Game()
//    stage.scene = game.scene
  }

  def quitGame():Unit ={
    stage.close()
  }
}
