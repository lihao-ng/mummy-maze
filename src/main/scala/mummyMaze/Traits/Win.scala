package Traits

import Components.Player
import scalafx.scene.image.ImageView

trait Win {
  def haveCollideExit(player: Player, exit: ImageView) = {
    player.intersects(exit.getBoundsInLocal)
  }
}
