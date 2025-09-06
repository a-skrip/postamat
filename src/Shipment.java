import java.math.BigDecimal;

public record Shipment(
        Dimensions shipmentSize, BigDecimal weight, String description) {
}
