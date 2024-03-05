# Sharding Setup

### Setup config server replication set
Connect to one of the cfg servers
```mongosh
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
