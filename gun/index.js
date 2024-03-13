import Gun from 'gun'

const gun = Gun()

// gun.put({ hello: 'world' })

gun.get('hello').on(data => console.log(data))

