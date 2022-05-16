package lottoauto.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    @Test
    void 숫자입력받아_1000으로나누기() {
        String input = "10000";

        Price price = new Price(input);
        assertThat(price.toString()).isEqualTo("Price{price=10000, tryTimes=10}");
    }

    @Test
    void 숫자입력받아_1000으로나눌수없음() {
        String input = "10000a";

        assertThatThrownBy(() -> new Price(input)).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 숫자입력안받아_나눌수없음() {
        String input = "";

        assertThatThrownBy(() -> new Price(input)).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 숫자입력_음수로() {
        String input = "-10000";

        Price price;
        assertThatThrownBy(() -> new Price(input)).isInstanceOf(NumberFormatException.class);
    }
}