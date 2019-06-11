package Components

import scalafx.scene.image.ImageView
import Maps.Map

class Character extends ImageView {
  def wallCollide(map: Map) = {
    map.walls.forall(wall => {
      !this.intersects(wall.getLayoutBounds)
    })
  }
}
