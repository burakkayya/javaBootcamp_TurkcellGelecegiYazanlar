package org.example;

public class VakifbankPosServiceAdapter implements PosService{
    @Override
    public boolean checkPayment() {
        VakifbankPosService vakifbankPosService = new VakifbankPosService();
        return vakifbankPosService.ode();
    }
}
