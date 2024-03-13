
// ! this doesnt work anymore the gun-mongo package is not maintained anymore
import Gun from 'gun'

// Must be added after Gun but before instantiating Gun
import 'gun-mongo'

// Instantiate Gun
const gun = new Gun({
    file: false,
    localStorage: false,

    // The following are defaults. You can supply `true` to use all defaults, or overwrite the ones you choose
    mongo: {
        host: 'localhost',
        port: '27017',
        username: null,
        password: null,
        database: 'gun',
        collection: 'gun-mongo',
        query: ''
    },
    //Instead of using an object (like above), you may also provide the MongoDB connection URI yourself:
    // mongo: "mongodb://127.0.0.1/gun"
});
