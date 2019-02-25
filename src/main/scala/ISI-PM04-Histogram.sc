import java.awt

import smile.data.parser.DelimitedTextParser
import smile.data.{DataFrame, NominalAttribute, NumericAttribute}
import java.awt.{Color, Dimension}

import smile.plot.{BoxPlot, Histogram, PlotPanel, Window}

// ISI - Predictive Modelling Excercise with Smile :)

// Data Processing
val parser = new DelimitedTextParser()
parser.setDelimiter(",")
parser.setColumnNames(true)
val data = parser.parse(new java.io.File("/Users/vijay/Downloads/Data/Credit_Card_Expenses.csv"))
val df = DataFrame(data)
val ccExpense = df.CC_Expenses.vector()

// Data Analysis
data.summary()

// Visualization : Histogram
val canvas = Histogram.plot(df.CC_Expenses.vector(),10) //train.x(), train.response().vector().map(_.toInt), Array('*', '+', 'o'), Array(Color.RED, Color.BLUE, Color.CYAN))
canvas.setAxisLabels("CC_Expenses","Probability")
canvas.setTitle("Histogram of CC Expenses v/s Month")
canvas.setTitleColor(Color.GRAY)

// Visualization : Box Plot
val canvas1 = BoxPlot.plot(df.CC_Expenses.vector())
canvas1.setAxisLabels("CC_Expenses","Probability")
canvas1.setTitle("BoxPlot of CC Expenses v/s Month")
canvas1.setTitleColor(Color.GRAY)

// Add multiple canvas
val panel = new PlotPanel(canvas, canvas1)
panel.setAutoscrolls(false)
val frame = Window.frame()
frame.setContentPane(panel)











