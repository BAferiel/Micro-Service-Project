const mongoose = require('mongoose');

const paymentSchema = new mongoose.Schema({
    amount: {
        type: Number,
        required: true,
    },
    currency: {
        type: String,
        required: true,
    },
    description: {
        type: String,
        required: true,
    },
    paymentIntentId: {
        type: String,
        required: true,
    },
});

const Payment = mongoose.model('Payment', paymentSchema);

module.exports = Payment;
