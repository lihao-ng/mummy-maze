package ch.makery.address.Traits

import ch.makery.address.Components.{Mummy, Player}

trait Death {
  def haveDied(player: Player, mummy: Mummy) = {
    player.intersects(mummy.getBoundsInLocal)
  }
}
