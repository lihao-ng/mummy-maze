package mummyMaze.Controller

import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import scalafx.scene.control.{Label, TextField}

@sfxml
class GameOverController(
      private val playerNameInput : TextField,
      private val scoreLabel : Label
    ) {


    def gameOverSubmit(actionEvent: ActionEvent): Unit = {
//        Main.backHomePage()
    }

}
