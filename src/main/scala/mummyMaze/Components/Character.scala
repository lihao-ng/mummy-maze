package Components

import scalafx.scene.image.ImageView
import scalafx.scene.shape.Rectangle

class Character extends ImageView {
  def wallCollide(walls: List[Rectangle]) = {
    walls.forall(wall => {
      !this.intersects(wall.getLayoutBounds)
    })
  }
}
