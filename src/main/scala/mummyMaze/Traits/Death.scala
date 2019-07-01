package mummyMaze.Traits

import mummyMaze.Components.{Mummy, Player}

trait Death {
  def haveDied(player: Player, mummy: Mummy) = {
    player.intersects(mummy.getBoundsInLocal)
  }
}
