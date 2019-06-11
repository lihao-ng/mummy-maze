package Traits

import Components.{Mummy, Player}
import scalafx.scene.shape.Rectangle

trait TrackMovement {
  def track(player: Player, mummy: Mummy, walls: List[Rectangle]) = {
    val playerX = player.x.value
    val playerY = player.y.value

    val mummyX = mummy.x.value
    val mummyY = mummy.y.value

    if(playerX >= mummyX) {
      mummy.image = Mummy.imageRight
      mummy.x.value += Mummy.step
      if (!mummy.wallCollide(walls)) mummy.x.value -= Mummy.step
    }else {
      mummy.image = Mummy.imageLeft
      mummy.x.value -= Mummy.step
      if (!mummy.wallCollide(walls)) mummy.x.value += Mummy.step
    }

    if(playerY >= mummyY) {
      mummy.y.value += Mummy.step
      if (!mummy.wallCollide(walls)) mummy.y.value -= Mummy.step
    }else  {
      mummy.y.value -= Mummy.step
      if (!mummy.wallCollide(walls)) mummy.y.value += Mummy.step
    }
  }
}
