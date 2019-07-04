package ch.makery.address.Controller

import ch.makery.address.Main
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class MainController() {

  def viewHighScore(actionEvent: ActionEvent): Unit = {
    Main.viewHighScore()
  }

  def startGame(actionEvent: ActionEvent): Unit = {
    Main.startGame()
  }

  def quitGame(actionEvent: ActionEvent): Unit = {
    Main.quitGame()
  }
}
