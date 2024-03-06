# Sharding Setup

### Setup config server replication set
Connect to one of the cfg servers
```bash
mongosh mongodb://localhost:40001
```

```mongosh
rs.initiate(
  {
    _id: "cfgrs",
    configsvr: true,
    members: [
      { _id : 0, host : "host.docker.internal:40001" },
      { _id : 1, host : "host.docker.internal:40002" },
      { _id : 2, host : "host.docker.internal:40003" }
    ]
})

rs.status()
```

### Setup shard replication set
Connect to one of the shard servers
```bash
mongosh mongodb://localhost:50001
```

```mongosh
rs.initiate(
  {
    _id: "shardrs",
    members: [
      { _id : 0, host : "host.docker.internal:50001" },
      { _id : 1, host : "host.docker.internal:50002" },
      { _id : 2, host : "host.docker.internal:50003" }
    ]
})
```

### Add shard to cluster
```bash
mongosh mongodb://localhost:60000

```
sh.addShard("shardrs/host.docker.internal:50001,host.docker.internal:50002,host.docker.internal:50003")

sh.status()
```mongosh

### Add second shard
Connect to one of the shard servers
```bash
mongosh mongodb://localhost:50004
```

```mongosh
rs.initiate(
  {
    _id: "shard2rs",
    members: [
      { _id : 0, host : "host.docker.internal:50004" },
      { _id : 1, host : "host.docker.internal:50005" },
      { _id : 2, host : "host.docker.internal:50006" }
    ]
})
```

Connect to mongos
```bash
mongosh mongodb://localhost:60000
```

```mongosh
sh.addShard("shard2rs/host.docker.internal:50004,host.docker.internal:50005,host.docker.internal:50006")
```

## Add collections to sharding
```bash
mongosh mongodb://localhost:60000
```


```mongosh
# Create DB and collections
use logsdb
db.createCollection("balloon_logs")
db.createCollection("pilot_logs")

# Check if sharding is enabled for collection
db.balloon_logs.getShardDistribution()

# Shard collection
sh.shardCollection("logsdb.balloon_logs", { _id: "hashed" })

# Check if sharding is enabled for collection
db.balloon_logs.getShardDistribution()

# Add some docs (can take some time)
for i in {1..50}; do echo -e "use logsdb \n db.balloon_logs.insertOne({name: 'balloon$i', code: $i, verified: false})" | mongosh mongodb://localhost:60000; done

db.balloon_logs.find()
```

# Experiment
## Add data to shard and see if it is accesible from router
```bash
mongosh mongodb://localhost:50004
```

```mongosh
use logsdb
db.balloon_logs.insertOne({name: 'balloon51', code: 51, verified: false})
```

## Check if data is accessible from mongos
```bash
mongosh mongodb://localhost:60000
```

```mongosh
use logsdb
db.balloon_logs.find()
```

## Conclusion
If we want to use shards as a complete seperate instance then we can't add data to it and except the router to be able to access it. 

## Search for a way to choose which shard to store it in (not ideal because all instances would be need to be able to access the mongo router)

