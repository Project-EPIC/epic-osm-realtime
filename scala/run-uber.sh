gradle clean && \
gradle shadowJar && \
scala -cp build/libs/spark-epic-osm-all.jar edu.colorado.cs.epic.SparkEpicOSM
