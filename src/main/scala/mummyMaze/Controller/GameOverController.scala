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

    var score = 12500

    scoreLabel.text = score.toString
    var playerName = playerNameInput.text

    def gameOverSubmit(actionEvent: ActionEvent) = {
        if(Main.playersHighScore.size < 6){
            print("entered")
            val highScoreRecord = new HighScoreRecord(playerName.value,new Score(score))
            highScoreRecord.save()
            Main.playersHighScore += highScoreRecord
            Main.backHomePage()
        }else {
            var lowestScore = Main.playersHighScore.minBy( highscore => highscore.score.value.v.value)
            if (score > lowestScore.score.value.v.value) {
                val delHighScoreRecord = lowestScore
                delHighScoreRecord.delete()
                Main.playersHighScore -= lowestScore

                val highScoreRecord = new HighScoreRecord(playerName.value,new Score(score))
                highScoreRecord.save()
                Main.playersHighScore += highScoreRecord

                playersHighScore.sort((s,t) => s.score.value.v.value > t.score.value.v.value)

                Main.backHomePage()
            }
        }
    }
}
