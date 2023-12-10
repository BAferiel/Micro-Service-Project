const express = require('express');
const router = express.Router();
const stripe = require('stripe')('sk_test_51OLb5WD8x9Pegs6Glw8nTaDXab1KvqRRtIMoZi32a8ZIrWmrScJ3sm7V08LMDP6He8x96AAJYhyWXCVyvA1M5d1A00G64FhYQi');
const Payment = require('../models/payment');

router.post('/process-payment', async (req, res) => {
    try {
        const paymentData = req.body;

        const intent = await stripe.paymentIntents.create({
            amount: paymentData.amount,
            currency: paymentData.currency,
            description: paymentData.description,
        });
        const payment = new Payment({
            amount: paymentData.amount,
            currency: paymentData.currency,
            description: paymentData.description,
            paymentIntentId: intent.id,
        });

        await payment.save();

        res.json({ success: true, clientSecret: intent.client_secret });
    } catch (error) {
        console.error('Payment Error:', error.message);
        res.status(500).json({ success: false, error: error.message });
    }
});

module.exports = router;
