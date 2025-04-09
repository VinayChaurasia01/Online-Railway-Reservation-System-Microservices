package com.railway.paymentgatewayservice.service;

import com.railway.paymentgatewayservice.client.BookingClient;
import com.railway.paymentgatewayservice.model.Payment;
import com.railway.paymentgatewayservice.model.PaymentRecord;
import com.railway.paymentgatewayservice.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@Service
public class PaymentService {

        @Autowired
        private BookingClient ticketClient;

        @Autowired
        private PaymentRepository paymentRepository;

        public String processPayment(Payment payment) {
            // Get the ticket amount from the Ticket Reservation Service
            double ticketAmount = ticketClient.getTicketAmount(payment.getPnr());

            // Simulate payment processing with a dummy payment gateway
            boolean paymentSuccess = simulatePaymentGateway(payment);

            // Create a PaymentRecord to save to the database
            PaymentRecord paymentRecord = new PaymentRecord();
            paymentRecord.setPnr(payment.getPnr());
            paymentRecord.setPaymentMethod(payment.getPaymentMethod());
            paymentRecord.setAmount(ticketAmount);
            paymentRecord.setSuccess(paymentSuccess);
            Calendar gmt = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            paymentRecord.setDate(gmt.getTime());

            // Save the payment record
            paymentRepository.save(paymentRecord);

            if (paymentSuccess) {
                return "Payment of " + ticketAmount + " processed successfully for PNR: " + payment.getPnr();
            } else {
                return "Payment processing failed. Please try again.";
            }
        }

        private boolean simulatePaymentGateway(Payment payment) {
            // Simulate a successful payment processing
            // In a real application, you would integrate with a payment gateway API here
            return true; // Simulating success
        }
}
