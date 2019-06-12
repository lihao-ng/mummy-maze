package Traits

import scalafx.scene.shape.Rectangle

trait KeyMovement {
  def moveLeft(walls: List[Rectangle]): Unit
  def moveRight(walls: List[Rectangle]): Unit
  def moveUp(walls: List[Rectangle]): Unit
  def moveDown(walls: List[Rectangle]): Unit
}
