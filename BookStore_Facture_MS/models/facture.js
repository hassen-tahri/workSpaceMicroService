const mongoose = require("mongoose");

const factureSchema = mongoose.Schema({
    reference: {
        type: String,
        require: false,
    },
    quantite: {
        type: Number,
        require: false,
    },
    montantTotal: {
        type: Number,
        require: false,
    },
    createAt: {
        type: Date,
        require: false,
    }
})

module.exports = Facture = mongoose.model("facture", factureSchema)