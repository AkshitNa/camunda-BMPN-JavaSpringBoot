var System = Java.type('java.lang.System');

var orderItems = [
    { name: "Laptop", price: 1000 },
    { name: "Mouse", price: 20 },
    { name: "Keyboard", price: 50 }
];

var totalAmount = 0;

for (var i = 0; i < orderItems.length; i++) {
    totalAmount += orderItems[i].price;
} //Sum

System.out.println("Total Amount calculated: $" + totalAmount);

if (totalAmount > 1000) {
    totalAmount = totalAmount - totalAmount*0.1;  // 10% discount
}

execution.setVariable("orderTotal", totalAmount);
System.out.println("Total Amount calculated with discount (if any) : $ " + totalAmount);