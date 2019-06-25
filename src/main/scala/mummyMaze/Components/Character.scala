package Components

import scalafx.scene.image.ImageView
import scalafx.scene.shape.Rectangle

class Character extends ImageView {
  def noWallCollision(walls: List[Rectangle]) = {
    walls.forall(wall => {
      !this.intersects(wall.getLayoutBounds)
    })
  }

  def haveCollideExit(exit: ImageView) = {
    this.intersects(exit.getBoundsInLocal)
  }
}
