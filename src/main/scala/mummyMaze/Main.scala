package mummyMaze

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

//  val playersHighScore = new ObservableBuffer[HighScoreRecord]()
  playersHighScore += new HighScoreRecord("Hans", new Score(1000))
  playersHighScore += new HighScoreRecord("Ben", new Score(1000))
  playersHighScore += new HighScoreRecord("Daniel", new Score(1000))
  playersHighScore += new HighScoreRecord("Nicholas", new Score(1000))
  playersHighScore += new HighScoreRecord("James", new Score(1000))

  val rootResource = getClass.getResource("view/Main.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots = loader.getRoot[jfxs.layout.AnchorPane]

  val music = playMusic()
  music.cycleCount = MediaPlayer.Indefinite
  music.play()

  stage = new PrimaryStage {
    maxWidth = 1025
    minWidth = 1025
    maxHeight = 748
    minHeight = 748
    title = "MummyMaze"
    scene = loadMainMenu()
  }

  def loadMainMenu(): Scene = {
    new Scene {
      content = roots
    }
  }

  def changeScreen(): Unit = {
    val game = new Game()
    stage.scene = game.scene
  }

  def playMusic(): MediaPlayer = {
    new MediaPlayer(new Media(getClass.getResource("musics/background_music.wav").toString))
  }

  def backHomePage(): Unit = {
    val resource = getClass.getResource("view/Main.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots2 = loader.getRoot[jfxs.layout.AnchorPane]
    stage.scene().setRoot(roots2)
  }

  def viewHighScore(): Unit = {
    val resource = getClass.getResource("view/HighScore.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots2 = loader.getRoot[jfxs.layout.AnchorPane]
    roots2.stylesheets = List(getClass.getResource("css/HighScorePage.css").toExternalForm)
    stage.scene().setRoot(roots2)
  }

  def startGame(): Unit = {
    val game = new Game()
    stage.scene = game.scene
  }

  def quitGame(): Unit = {
    System.exit(0)
//    stage.close()
  }
}
