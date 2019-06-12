package Maps

import scalafx.scene.shape.Rectangle


object Stage2 {
  val outerWall1 = Rectangle (700.0, 35.0)
  val outerWall2 = Rectangle (0.0, 665.0, 700.0, 35.0)
  val outerWall3 = Rectangle (35.0, 598.0)
  val outerWall4 = Rectangle (665.0, 0.0, 35.0, 700.0)
  val wall1 = Rectangle (152.0, 35.0, 35.0, 100.0)
  val wall2 = Rectangle (475.0, 35.0, 35.0, 100.0)
  val wall3 = Rectangle (276.0, 100.0, 200.0, 35.0)
  val wall4 = Rectangle (35.0, 218.0, 394.0, 35.0)
  val wall5 = Rectangle (151.0, 253.0, 35.0, 100.0)
  val wall6 = Rectangle (394.0, 253.0, 35.0, 100.0)
  val wall7 = Rectangle (301.0, 353.0, 269.0, 35.0)
  val wall8 = Rectangle (35.0, 457.0, 269.0, 35.0)
  val wall9 = Rectangle (151.0, 492.0, 35.0, 100.0)
  val wall10 = Rectangle (533.0, 457.0, 35.0, 207.0)
  val wall11 = Rectangle (412.0, 457.0, 122.0, 35.0)

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
    wall11
//    outerWall1,
//    outerWall2,
//    outerWall3,
//    outerWall4
  )
}
