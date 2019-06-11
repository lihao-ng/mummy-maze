package Traits

import Components.Player
import Maps.Map

trait Win {
  def haveCollideExit(player: Player, map: Map) = {
    if(player.intersects(map.exit.getBoundsInLocal)) {
      println("WIN")
    }
  }
}
