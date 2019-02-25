import java.awt

import smile.data.parser.DelimitedTextParser
import smile.data.{DataFrame, NominalAttribute, NumericAttribute}
import java.awt.{Color}
import smile.math.Math

import smile.plot.{BoxPlot, PlotPanel, Window}

// ISI - Predictive Modelling Excercise with Smile :)

// Data Processing
val parser = new DelimitedTextParser()
parser.setDelimiter(",")
parser.setColumnNames(true)
val data = parser.parse(new java.io.File("/Users/vijay/Downloads/Data/CC_Expenses_Exercise.csv"))
val df = DataFrame(data)
df.colnames
df.groupBy("Sex").filter(x=> x._1 == 1)

val d1 = df.groupBy("Sex", "Shopping").get(1,1) match {
  case Some(df) => df.Credit_Card_usage
}
val d2 = df.groupBy("Sex", "Shopping").get(2,2) match {
  case Some(df) => df.Credit_Card_usage
}
// Data Analysis
print("Mean : ", Math.mean(d1.vector()))

// Visualization : Box Plot
val canvas1 = BoxPlot.plot(d1.vector(),d2.vector())
canvas1.setAxisLabels("","CC_Expenses")
canvas1.setTitle("BoxPlot of CC Expenses for Sex")
canvas1.setTitleColor(Color.GRAY)

// Add multiple canvas
val panel = new PlotPanel(canvas1)
panel.setAutoscrolls(false)
val frame = Window.frame()
frame.setContentPane(panel)











