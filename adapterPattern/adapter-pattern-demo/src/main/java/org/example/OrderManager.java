package org.example;

public class OrderManager {
    private final PosService posService;

    public OrderManager(PosService posService) {
        this.posService = posService;
    }

    public void makePayment(){

        //business kodları

        if(posService.checkPayment()){
            System.out.println("Payment is successful");
        }else {
            System.out.println("Payment is failed");
        }

        //sipariş kodları
    }
}
