sbt package
spark-submit --class "main.WordCount" --master local[*] "target/scala-2.11/wordcountscala_2.11-0.1.jar" "bible.txt" "results"