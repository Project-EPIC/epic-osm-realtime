gradle jar && \
scala -cp "dependencies/jackson-paranamer.jar:dependencies/jackson-annotations.jar:dependencies/jackson-core.jar:dependencies/jackson-databind.jar:dependencies/jackson.jar:dependencies/geow.jar:dependencies/compress.jar:dependencies/proto.jar:build/libs/spark-epic-osm.jar" edu.colorado.cs.epic.SparkEpicOSM

# scala -cp "build/libs/spark-epic-osm-all.jar" edu.colorado.cs.epic.SparkEpicOSM