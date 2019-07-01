package Maps

import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import java.io.File

import scalafx.scene.image.{Image, ImageView}

object Level1 {
    val color = Color.rgb(139, 69, 19)

    val outerWall1 = Rectangle(700.0, 35.0)
    outerWall1.fill = color

    val outerWall2 = Rectangle(0.0, 665.0, 700.0, 35.0)
    outerWall2.fill = color

    val outerWall3 = Rectangle(35.0, 598.0)
    outerWall3.fill = color

    val outerWall4 = Rectangle(665.0, 0.0, 35.0, 700.0)
    outerWall4.fill = color

    val wall1 = Rectangle(152.0, 35.0, 35.0, 100.0)
    wall1.fill = color

    val wall2 = Rectangle(475.0, 35.0, 35.0, 100.0)
    wall2.fill = color

    val wall3 = Rectangle(276.0, 100.0, 200.0, 35.0)
    wall3.fill = color

    val wall4 = Rectangle(35.0, 218.0, 151.0, 35.0)
    wall4.fill = color

    val wall5 = Rectangle(282.0, 218.0, 147.0, 35.0)
    wall5.fill = color

    val wall6 = Rectangle(151.0, 253.0, 35.0, 100.0)
    wall6.fill = color

    val wall7 = Rectangle(394.0, 253.0, 35.0, 100.0)
    wall7.fill = color

    val wall8 = Rectangle(282.0, 353.0, 288.0, 35.0)
    wall8.fill = color

    val wall9 = Rectangle(35.0, 457.0, 269.0, 35.0)
    wall9.fill = color

    val wall10 = Rectangle(151.0, 492.0, 35.0, 100.0)
    wall10.fill = color

    val wall11 = Rectangle(533.0, 458.0, 35.0, 207.0)
    wall11.fill = color

    val wall12 = Rectangle(412.0, 458.0, 122.0, 35.0)
    wall12.fill = color

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
      outerWall4
    )
}
