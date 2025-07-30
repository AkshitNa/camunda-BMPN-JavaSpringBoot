var System = Java.type('java.lang.System');

var orderTotal = execution.getVariable("orderTotal");

var paymentSuccessful = (Math.random() < 0.8);  // 80% chance of success

if (paymentSuccessful) {
    System.out.println("Payment of $" + orderTotal + " processed successfully.");
    execution.setVariable("paymentStatus", "SUCCESS");
} else {
    System.out.println("Payment of $" + orderTotal + " failed. Please try again.");
    execution.setVariable("paymentStatus", "FAILED");
}