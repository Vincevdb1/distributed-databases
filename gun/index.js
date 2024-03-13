import Gun from 'gun'

const gun = Gun()

// gun.put({
//     id: '1',
//     log: {
//         date: '2020-01-01',
//         message: 'Hello, world!',
//         from: 'location1',
//         to: 'location2'
//     }
// })

gun.get('1').on(function (data) {
    console.log(data)
})
