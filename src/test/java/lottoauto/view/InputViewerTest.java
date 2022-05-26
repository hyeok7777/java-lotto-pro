package lottoauto.view;

import lottoauto.wrapper.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class InputViewerTest {

    Scanner scanner = new Scanner(System.in);

    @ParameterizedTest
    @DisplayName("수동 입력 시 구매숫자 확인 테스트")
    @ValueSource(strings = {"4"})
    void manualLottoPriceTest(String input) {
        Price price = new Price(14000, 14, 0);
        InputViewer inputViewer = new InputViewer();

        InputStream in = generateUserInput(input);
        System.setIn(in);
        inputViewer.inputManualLotto(price);

        scanner = new Scanner(System.in);
        assertThat(price.getTryTimes()).isEqualTo(10);

    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}