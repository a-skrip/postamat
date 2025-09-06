import java.math.BigDecimal;

public record Dimensions(
        BigDecimal length,
        BigDecimal width,
        BigDecimal height) {

    public boolean canHold(Dimensions dimensions) {
        return this.length.compareTo(dimensions.length) >= 0 &&
                this.width.compareTo(dimensions.width) >= 0 &&
                this.height.compareTo(dimensions.height) >= 0;
    }
}
