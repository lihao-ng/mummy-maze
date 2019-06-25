package Traits

import Components.{Mummy, Player}
import scalafx.scene.image.ImageView
import scalafx.scene.shape.Rectangle

trait TrackMovement {
  def track(player: Player, mummy: Mummy, walls: List[Rectangle], exit: ImageView) = {
    val playerX = player.x.value
    val playerY = player.y.value

    val mummyX = mummy.x.value
    val mummyY = mummy.y.value

    if(playerX >= mummyX) {
      mummy.image = Mummy.imageRight
      mummy.x.value += Mummy.step
      if (!mummy.noWallCollision(walls)) mummy.x.value -= Mummy.step
      if (mummy.haveCollideExit(exit)) mummy.x.value -= Mummy.step
    }else {
      mummy.image = Mummy.imageLeft
      mummy.x.value -= Mummy.step
      if (!mummy.noWallCollision(walls)) mummy.x.value += Mummy.step
      if (mummy.haveCollideExit(exit)) mummy.x.value += Mummy.step
    }

    if(playerY >= mummyY) {
      mummy.y.value += Mummy.step
      if (!mummy.noWallCollision(walls)) mummy.y.value -= Mummy.step
      if (mummy.haveCollideExit(exit)) mummy.y.value -= Mummy.step
    }else  {
      mummy.y.value -= Mummy.step
      if (!mummy.noWallCollision(walls)) mummy.y.value += Mummy.step
      if (mummy.haveCollideExit(exit)) mummy.y.value -= Mummy.step
    }
  }
}
