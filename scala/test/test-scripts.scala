/*

    This can all be pasted into the REPL

*/

import java.nio.file.{Files,Path,Paths}
import java.io.{File,PrintWriter}

import edu.colorado.cs.epic._

var inFile = Paths.get("test/meta_changeset_way_change.json").toAbsolutePath.normalize
var string = SparkEpicOSM.get_stuff(inFile)

val metaObject = PlanetStreamParser.parseObject(string)
