package ch.makery.address.Components

import scalafx.scene.image.ImageView
import scalafx.scene.shape.Rectangle

class Character extends ImageView {
  def noWallCollision(walls: List[Rectangle]): Boolean = {
    walls.forall(wall => {
      !this.intersects(wall.getLayoutBounds)
    })
  }

  def haveCollideExit(exit: ImageView): Boolean = {
    this.intersects(exit.getBoundsInLocal)
  }
}
