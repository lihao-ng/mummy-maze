package Maps

import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle


object Level2 {
  val outerWall1 = Rectangle (700.0, 35.0)
  outerWall1.fill = Color.rgb(216, 155, 49)

  val outerWall2 = Rectangle (0.0, 665.0, 700.0, 35.0)
  outerWall2.fill = Color.rgb(216, 155, 49)

  val outerWall3 = Rectangle (35.0, 598.0)
  outerWall3.fill = Color.rgb(216, 155, 49)

  val outerWall4 = Rectangle (665.0, 0.0, 35.0, 700.0)
  outerWall4.fill = Color.rgb(216, 155, 49)

  val outerWall5 = Rectangle (665.0, 35.0, 35.0, 100.0)
  outerWall5.fill = Color.rgb(216, 155, 49)

  val wall1 = Rectangle (105.0, 180.0, 250.0, 35.0)
  wall1.fill = Color.rgb(216, 155, 49)

  val wall2 = Rectangle (105.0, 100.0, 35.0, 80.0)
  wall2.fill = Color.rgb(216, 155, 49)

  val wall3 = Rectangle (212.0, 215.0, 35.0, 172.0)
  wall3.fill = Color.rgb(216, 155, 49)

  val wall4 = Rectangle (105.0, 454.0, 35.0, 100.0)
  wall4.fill = Color.rgb(216, 155, 49)

  val wall5 = Rectangle (247.0, 352.0, 108.0, 35.0)
  wall5.fill = Color.rgb(216, 155, 49)

  val wall6 = Rectangle (230.0, 564.0, 35.0, 100.0)
  wall6.fill = Color.rgb(216, 155, 49)

  val wall7 = Rectangle (450.0, 284.0, 35.0, 380.0)
  wall7.fill = Color.rgb(216, 155, 49)

  val wall8 = Rectangle (360.0, 504.0, 90.0, 35.0)
  wall8.fill = Color.rgb(216, 155, 49)

  val wall9 = Rectangle (485.0, 378.0, 90.0, 35.0)
  wall9.fill = Color.rgb(216, 155, 49)

  val wall10 = Rectangle (443.0, 106.0, 108.0, 35.0)
  wall10.fill = Color.rgb(216, 155, 49)

  val wall11 = Rectangle (550.0, 106.0, 35.0, 130.0)
  wall11.fill = Color.rgb(216, 155, 49)

  val wall12 = Rectangle (550.0, 234.0, 116.0, 35.0)
  wall12.fill = Color.rgb(216, 155, 49)

  val walls = List(
    wall1,
    wall2,
    wall3,
    wall4,
    wall5,
    wall6,
    wall7,
    wall8,
    wall9,
    wall10,
    wall11,
    wall12,
    outerWall1,
    outerWall2,
    outerWall3,
    outerWall4,
    outerWall5
  )
}
