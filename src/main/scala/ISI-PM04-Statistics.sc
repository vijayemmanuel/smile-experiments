import smile.data.parser.DelimitedTextParser
import smile.data.{DataFrame, NominalAttribute, NumericAttribute}
import smile.math.Math
import smile.stat.hypothesis.TTest

// ISI - Predictive Modelling Excercise with Smile :)

// Data Processing
val parser = new DelimitedTextParser()
parser.setDelimiter(",")
parser.setColumnNames(true)
val data = parser.parse(new java.io.File("/Users/vijay/Downloads/Data/PO_Processing.csv"))
val df = DataFrame(data)
df.colnames

// Data Analysis
val size = df.Processing_Time.vector().length
val mean = Math.mean(df.Processing_Time.vector())
print ("mean : ",mean)
val sd = Math.sd(df.Processing_Time.vector())
print ("sd : ",sd)
print ("t value : ",(mean-40)/(sd/Math.sqrt(size)))

// Get the p value . assume population mean to be 40
val p = TTest.test(df.Processing_Time.vector(),40).pvalue








