Epic OSM Realtime
=================

Processing a realtime stream of OpenStreetMap data can be considered similar to listening to / processing data from the Twitter Streaming API.

This repository demonstrates and implements different techniques for handling real-time OSM data.

### Planet-Stream by DevelopmentSeed
DevSeed has built [Blog post](https://developmentseed.org/blog/2015/09/28/whats-trending-osm/) to support collection and aggregation of editing statistics during Mapathons. [The repository is here](https://github.com/developmentseed/planet-stream). An example of what it can power is the [Missing Maps leaderboard page](http://www.missingmaps.org/leaderboards/#/missingmaps) 

PlanetStream is powered by `osm-meta-util`. Future work will consider using this stream in conjunction with PostgreSQL and redis for a near realtime cache of OSM edits, though this requires the overpass API to perform a lot of heavy lifting.

**Epic OSM** is capable of realtime processing by using a sliding window for analysis. Since the base object is an `analysis window`, the sliding window is implemented by continually updating the bounds on an analysis window and changing the output directory to represent the current hour. 
[Realtime Script](https://github.com/Project-EPIC/epic-osm/blob/master/modules/realtime.rb)
[Import Nodeways from OSM API](https://github.com/Project-EPIC/epic-osm/blob/master/import_scripts/osm_api/import_nodeways.rb)
