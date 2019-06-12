package Traits

import Components.Player
import scalafx.scene.shape.Rectangle

trait Win {
  def haveCollideExit(player: Player, exit: Rectangle) = {
    player.intersects(exit.getBoundsInLocal)
  }
}
