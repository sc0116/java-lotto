# java-lotto

로또 미션 저장소

1. 구입금액을 입력받는다.
    * 0보다 큰 숫자가 아닌 경우, RuntimeException을 발생시킨다.


2. 수동으로 구매할 로또 개수를 입력받는다.
    * 0보다 큰 숫자가 아닌 경우


3. 수동으로 구매할 로또 개수만큼 로또 번호를 입력받는다.
    * 6개가 아닌 경우
    * 문자가 들어온 경우
    * 1-45 사이의 숫자가 아닌 경우
    * 중복 숫자인 경우


4. 당첨 번호를 입력받는다.
   * 6개가 아닌 경우
   * 문자가 들어온 경우
   * 1-45 사이의 수가 아닌경우
   * 중복 숫자인 경우


5. 보너스 번호를 입력받는다.
   * 1-45 사이의 숫자가 아닌경우
   * 당첨 번호와 중복된 경우


6. 로또 번호를 자동으로 생성한다.


7. 등수를 계산한다.


8. 통계를 저장하고 출력한다.


9. 수익률을 계산하고 출력한다.

---

* model(domain)
    * Lotto
    * LottoMachine
    * Lottos - 일급컬렉션
    * LottoStatistics
    * Money
    * Rank
    * WinningLotto

* controller
    * LottoController
    
* util
    * RandomGenerator
    * InputValidator

* view
    * InputView
    * ResultView



## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

