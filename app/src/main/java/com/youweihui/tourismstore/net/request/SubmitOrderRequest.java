package com.youweihui.tourismstore.net.request;

public class SubmitOrderRequest {

    private int addressId;

    private int integralGoodsId;

    private int number;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getIntegralGoodsId() {
        return integralGoodsId;
    }

    public void setIntegralGoodsId(int integralGoodsId) {
        this.integralGoodsId = integralGoodsId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
