package mummyMaze.Controller

import Components.{HighScoreRecord, Score}
import scalafx.scene.control.{TableColumn, TableView}
import mummyMaze.Main
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class HighScoreRecordController(
  private val playersHighScoreTable : TableView[HighScoreRecord],
  private val playerNameColumn : TableColumn[HighScoreRecord, String],
  private val scoreColumn : TableColumn[HighScoreRecord, Int]
  ) {

  playersHighScoreTable.items = Main.playersHighScore
  playerNameColumn.cellValueFactory = {_.value.playerName}
  scoreColumn.cellValueFactory = {x => x.value.score.value.v}

  def back(actionEvent: ActionEvent) = {
    Main.backHomePage()
  }

//  def handleNewRecord(action : ActionEvent) = {
//    val person = new Person("","")
//    val okClicked = MainApp.showPersonEditDialog(person);
//    if (okClicked) {
//      person.save()
//      MainApp.personData += person
//    }
//  }
}