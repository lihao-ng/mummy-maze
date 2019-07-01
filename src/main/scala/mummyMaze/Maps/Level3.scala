package Maps

import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

object Level3 {
    val color = Color.rgb(139, 69, 19)

    val outerWall1 = Rectangle (700.0, 35.0)
    outerWall1.fill = color

    val outerWall2 = Rectangle (0.0, 665.0, 700.0, 35.0)
    outerWall2.fill = color

    val outerWall3 = Rectangle (35.0, 598.0)
    outerWall3.fill = color

    val outerWall4 = Rectangle (665.0, 0.0, 35.0, 700.0)
    outerWall4.fill = color

    val wall1 = Rectangle(188.0, 240.0, 108.0, 35.0)
    wall1.fill = color

    val wall2 = Rectangle(120.0, 565.0, 35.0, 100.0)
    wall2.fill = color

    val wall3 = Rectangle(153.0, 407.0, 35.0, 100.0)
    wall3.fill = color

    val wall4 = Rectangle(188.0, 472.0, 108.0, 35.0)
    wall4.fill = color

    val wall5 = Rectangle(153.0, 240.0, 35.0, 100.0)
    wall5.fill = color

    val wall6 = Rectangle(410.0, 404.0, 35.0, 100.0)
    wall6.fill = color

    val wall7 = Rectangle(437.0, 159.0, 35.0, 100.0)
    wall7.fill = color

    val wall8 = Rectangle(153.0, 124.0, 145.0, 35.0)
    wall8.fill = color

    val wall9 = Rectangle(437.0, 124.0, 128.0, 35.0)
    wall9.fill = color

    val wall10 = Rectangle(519.0, 351.0, 35.0, 100.0)
    wall10.fill = color

    val wall11 = Rectangle(557.0, 254.0, 108.0, 35.0)
    wall11.fill = color

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
      outerWall1,
      outerWall2,
      outerWall3,
      outerWall4
    )
}
