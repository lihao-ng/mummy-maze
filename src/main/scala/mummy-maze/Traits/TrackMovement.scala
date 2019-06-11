package Traits

import Maps.Map
import Components.{Mummy, Player}

trait TrackMovement {
  def track(player: Player, mummy: Mummy, map: Map) = {
    val playerX = player.x.value
    val playerY = player.y.value

    val mummyX = mummy.x.value
    val mummyY = mummy.y.value

    if(playerX > mummyX) {
      mummy.image = Mummy.imageRight
      mummy.x.value += Mummy.step
      if (!mummy.wallCollide(map)) mummy.x.value -= Mummy.step
    }

    if(playerX < mummyX) {
      mummy.image = Mummy.imageLeft
      mummy.x.value -= Mummy.step
      if (!mummy.wallCollide(map)) mummy.x.value += Mummy.step
    }

    if(playerY > mummyY) {
      mummy.y.value += Mummy.step
      if (!mummy.wallCollide(map)) mummy.y.value -= Mummy.step
    }

    if(playerY < mummyY) {
      mummy.y.value -= Mummy.step
      if (!mummy.wallCollide(map)) mummy.y.value += Mummy.step
    }
  }
}
