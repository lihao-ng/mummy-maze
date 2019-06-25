package mummyMaze.Controller

import mummyMaze.Main
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class MainController() {

  def viewHighScore(actionEvent: ActionEvent) = {
    Main.viewHighScore()
  }

  def startGame(actionEvent: ActionEvent) = {
    Main.startGame()
  }

  def quitGame(actionEvent: ActionEvent) = {
    Main.quitGame()
  }
}
