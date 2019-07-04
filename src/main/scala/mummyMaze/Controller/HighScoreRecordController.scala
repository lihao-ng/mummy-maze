package mummyMaze.Controller

import mummyMaze.Components.{HighScoreRecord, Score}
import scalafx.scene.control.{TableColumn, TableView}
import mummyMaze.Main
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import scalikejdbc.DB
import scalikejdbc._

@sfxml
class HighScoreRecordController(
 private val playersHighScoreTable : TableView[HighScoreRecord],
 private val playerNameColumn : TableColumn[HighScoreRecord, String],
 private val scoreColumn : TableColumn[HighScoreRecord, Int]
) {

  playersHighScoreTable.items = Main.playersHighScore
  playerNameColumn.cellValueFactory = {_.value.playerName}
  scoreColumn.cellValueFactory = {x => x.value.score.value.v}

  def back(actionEvent: ActionEvent): Unit = {
    Main.backHomePage()
  }

  def resetRecord: Unit = {
    HighScoreRecord.resetRecord
  }

}