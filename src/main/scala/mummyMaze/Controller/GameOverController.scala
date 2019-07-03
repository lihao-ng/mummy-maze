package mummyMaze.Controller

import mummyMaze.Components.{HighScoreRecord, Score}
import mummyMaze.Main
import mummyMaze.Main.playersHighScore
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import scalafx.scene.control.{Label, TextField}

@sfxml
class GameOverController(
  private val playerNameInput : TextField,
  private val scoreLabel : Label
) {

  var score : Score = new Score(0)
  var playerName = playerNameInput.text

  def setScore(_score: Score): Unit ={
    score = _score
    scoreLabel.text = score.v.value.toString
  }

  def gameOverSubmit(actionEvent: ActionEvent) = {
    if(playerName.value == "") playerName.value = "Unknown"

    if(Main.playersHighScore.size < 5){
      saveHighScore()
    }else {
      val lowestScore = Main.playersHighScore.minBy( highscore => highscore.score.value.v.value)

      if (score.v.value > lowestScore.score.value.v.value) {
        val delHighScoreRecord = lowestScore
        delHighScoreRecord.delete()
        Main.playersHighScore -= lowestScore
        saveHighScore()
      }
    }

    Main.backHomePage()
  }

  def saveHighScore(): Unit = {
    val highScoreRecord = new HighScoreRecord(playerName.value, score)
    Main.playersHighScore += highScoreRecord
    highScoreRecord.save()
    playersHighScore.sort((s,t) => s.score.value.v.value > t.score.value.v.value)
  }
}
