package Components

import scalafx.scene.image.ImageView
import Maps.Map
import scalafx.scene.shape.Rectangle

class Character extends ImageView {
  def wallCollide(walls: List[Rectangle]) = {
    walls.forall(wall => {
      !this.intersects(wall.getLayoutBounds)
    })
  }
}
