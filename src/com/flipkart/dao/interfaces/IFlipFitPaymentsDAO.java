package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitPayments;

public interface IFlipFitPaymentsDAO {
    public void setPaymentInfo(FlipFitPayments FFP);
    public void deletePaymentInfo(FlipFitPayments FFP);
}
