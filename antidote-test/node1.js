let antidoteClient = require('antidote_ts_client')
let antidote = antidoteClient.connect(8087, "localhost")

let balloonSet = antidote.set("balloons")


// antidote.update(
//     balloonSet.add("red")
// ).then(() => {
//     console.log("Added red balloon")
// })

// balloonSet.read().then((balloons) => {
//     console.log(balloons)
// })

// JSON
antidote.update(
    balloonSet.add({ color: "red", size: "medium" }),
).then(() => {
    console.log("Added red balloon")
})

balloonSet.read().then((balloons) => {
    console.log(balloons)
})
