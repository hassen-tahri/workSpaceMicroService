const express = require("express");
const mongoose = require("mongoose");
const Facture = require("./models/facture")
const bodyParser = require("body-parser")
const Eureka = require('eureka-js-client').Eureka
const eurekaHost = (process.env.EUREKA_CLIENT_SERVICEURL_DEFAULTZONE || '127.0.0.1');
const hostName = (process.env.HOSTNAME || 'localhost')
const ipAddr = '127.0.0.1';
const app = express();
const mongodbUrl = "mongodb+srv://adminMs:adminMs@clusterbookstore.kbufu.mongodb.net/BookStoreBd?retryWrites=true&w=majority"
const port_local = 5000
const  port_eureuka = 8081;

//monogDb config
mongoose.connect(
    mongodbUrl,
   (err, done) => {
        if (err) { console.log(err); }
        if (done) { console.log("base connecte") }
    }
);

//listener port config
app.listen(port_local, () => { console.log("server starting") })


// const client = new Eureka({
//     // application instance information
//     instance: {
//         app: 'Facture_Server',
//         instanceId: 'Facture_Server',
//         hostName: 'localhost',
//         ipAddr: '127.0.0.1',
//         port: {
//             '$': port_local,
//             '@enabled': 'true',
//         },
//         vipAddress: 'Facture_Server',
//         dataCenterInfo: {
//             '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
//             name: 'MyOwn',
//         },
//         registerWithEureka: true,
//         fetchRegistry: true,
//     },
//     eureka: {
//         // eureka server host / port
//         host: '127.0.0.1',
//         port: port_eureuka,
//         servicePath: '/eureka/apps',
//         registerWithEureka: true,
//         fetchRegistry: true,
//     },
// });

const client = new Eureka({
    instance: {
      app: 'Facture_Server',
      instanceId: 'Facture_Server',
      hostName: hostName,
      ipAddr: ipAddr,
      port: {
        '$': port_local,
        '@enabled': 'true',
      },
      vipAddress: "Facture_Server",
      dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn',
      },
    },
    //retry 10 time for 3 minute 20 seconds.
    eureka: {
      host: eurekaHost,
      port: port_eureuka,
      servicePath: '/eureka/apps/',
      maxRetries: 10,
      requestRetryDelay: 2000,
    },
  })

//start register
client.logger.level('debug');
client.start((error) => {
    console.log(error || 'complete');
});






// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

// parse application/json
app.use(bodyParser.json())

//test
app.get('/test', async (req, res) => {
    try {
        res.send("ani houni")
    } catch (error) {
        console.log(error)
    }
})



//get all factures
app.get('/factures', async (req, res) => {
    try {
        await Facture.find({})
            .then(result => {
                res.send(result)
            })
    } catch (error) {
        console.log(error)
    }
})


//getbyId
app.get('/facture/:id', async (req, res) => {
    try {
        await Facture.findById({ id: req.params.id })
            .then(result => {
                res.send(result)
            })
    } catch (error) {
        console.log(error)
    }
})

//add facture
app.post("/facture", async (req, res) => {
    try {
        let newFacture = new Facture({
            reference: req.body.reference,
            quantite: req.body.quantite,
            montantTotal: req.body.montantTotal,
            createAt: req.body.createAt
        })
        await newFacture.save().then(result => {
            res.send(result)
        })
    } catch (error) {
        console.log(error)

    }
})

//delete facture by id
app.delete("/facture/:id", async (req, res) => {
    try {
        await Facture.findOneAndDelete({ id: req.params.id });
        res.send("suppression avec succes")
    } catch (error) {
        res.send(error);
    }
})

//edite facture by id
app.put("/facture/:id", async (req, res) => {
    try {
        await Facture.findByIdAndUpdate({ _id: req.params.id }, {
            reference: req.body.reference,
            quantite: req.body.quantite,
            montantTotal: req.body.montantTotal,
            createAt: req.body.createAt
        }).then(result => {
            res.send(result)
        })
    } catch (error) {
        res.send(error)
    }
})

