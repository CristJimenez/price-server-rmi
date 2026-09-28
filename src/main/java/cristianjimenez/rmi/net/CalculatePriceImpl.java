package cristianjimenez.rmi.net;

import cristianjimenez.rmi.lib.IRemoteCalculatePrice;
import cristianjimenez.rmi.lib.PriceData;

public class CalculatePriceImpl implements IRemoteCalculatePrice {

    private PriceData data;

    public CalculatePriceImpl() {
    }

    @Override
    public PriceData calculateUnitPrice(PriceData data) {

        float result = 0;

        if (data.getPrice() <= 0 || data.getQuantity() <= 0) {
            data.setInterpretation("ERROR: price and quantity must be greater than 0");
            return data;
        } else {
            result = data.getPrice() / data.getQuantity();
            data.setResult(result);

            if (result < 1000) {
                data.setInterpretation("Very low unit price");
            } else if (result >= 1000 && result <= 10000) {
                data.setInterpretation("Competitive unit price");
            } else if (result > 10000 && result <= 50000) {
                data.setInterpretation("Moderate unit price");
            } else {
                data.setInterpretation("High unit price");
            }

            return data;
        }
    }
}
