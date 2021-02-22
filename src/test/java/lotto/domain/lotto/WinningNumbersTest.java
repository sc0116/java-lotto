package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.withPrecision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호에 중복이 있는 경우 예외")
    void valueOfDuplicatedNumber() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> WinningNumbers.valueOf("1,2,3,4,5,1", "1, 3")
        ).withMessage("로또 넘버에 중복이 있습니다.");
    }

    @Test
    @DisplayName("비정상적인 보너스 번호 입력인 경우 예외")
    void valueOfInvalidBonusNumber() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> WinningNumbers.valueOf("1,2,3,4,5,6", "1, 3")
        ).withMessage("불가능한 로또 번호입니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복이 되는 경우 예외")
    void duplicateBonusNumberWithLottoNumbers() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> WinningNumbers.valueOf("1,2,3,4,5,6", "3")
        ).withMessage("보너스 번호는 로또 번호와 달라야 합니다.");
    }

    @Test
    @DisplayName("등수 계산을 반환")
    void getStatistics() {
        WinningNumbers winningNumbers = WinningNumbers.valueOf("1, 2, 3, 4, 5, 6", "7");
        Map<Rank, Long> expected = new HashMap<>();
        expected.put(Rank.FIRST, 1L);
        expected.put(Rank.SECOND, 1L);
        expected.put(Rank.THIRD, 1L);
        expected.put(Rank.FOURTH, 0L);
        expected.put(Rank.FIFTH, 0L);
        expected.put(Rank.FAIL, 0L);
        int expectedTotalWinnings =
            Rank.FIRST.getWinnings() + Rank.SECOND.getWinnings() + Rank.THIRD.getWinnings();

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(
            LottoNumbers.valueOf("1,2,3,4,5,6"),
            LottoNumbers.valueOf("1,2,3,4,5,34"),
            LottoNumbers.valueOf("1,2,3,4,5,7")
        ));
        WinningStatistics result = lottoTicket.getWinningStatistics(winningNumbers);

        Map<Rank, Long> actual = result.getRanks().unwrap();

        assertThat(expected).isEqualTo(actual);
        assertThat(expectedTotalWinnings / 3000D)
            .isEqualTo(result.getYield().unwrap(), withPrecision(2d));
    }
}