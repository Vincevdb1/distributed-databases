let antidoteClient = require('antidote_ts_client')
let antidote = antidoteClient.connect(8088, "localhost")

let balloonSet = antidote.set("balloons")

balloonSet.read().then((balloons) => {
    console.log(balloons)
})
