package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ElementTest {

    @Test
    void 쪼개진_입력문자열의_요소는_값을_가진다() {
        //Given
        int testValue = 1;
        Element element = new Element(testValue);
        //When
        //Then
        assertThat(element.value).isEqualTo(1);
    }

    @Test
    void 정수로_Element를_생성할_수_있다() {
        //Given
        int testValue = 1;
        Element element = Element.from(testValue);
        //When
        //Then
        assertThat(element.value).isEqualTo(testValue);
    }

    @Test
    void 문자열로_Element를_생성할_수_있다() {
        //Given
        String testValue = "1";
        Element element = Element.from(testValue);
        //When
        //Then
        assertThat(element.value).isEqualTo(1);
    }

    @Test
    void 음수값이_전달될_경우_RuntimeException이_발생한다() {
        //Given
        String testValue = "-1";
        //When
        //Then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Element.from(testValue);
                }).withMessageContaining("음수");
    }

    @Test
    void 문자값이_전달될_경우_RuntimeException이_발생한다() {
        //Given
        String testValue = "안녕!? 내 이름은 문자야 :)";
        //When
        //Then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Element.from(testValue);
                }).withMessageContaining("0 이상의 자연수");
    }
}
