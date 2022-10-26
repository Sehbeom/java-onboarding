package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Nested
    class Problem1Test {
        // decideWinner() 테스트
        @Test
        void decideWinnerTest() {
            // pobi 승
            int pobiWinScore = 10;
            int crongLoseScore = 9;

            // crong 승
            int pobiLoseScore = 9;
            int crongWinScore = 10;

            // 무승부
            int pobiDrawScore = 10;
            int crongDrawScore = 10;

            Problem1 problem1 = new Problem1();
            assertThat(problem1.decideWinner(pobiWinScore, crongLoseScore)).isEqualTo(1);
            assertThat(problem1.decideWinner(pobiLoseScore, crongWinScore)).isEqualTo(2);
            assertThat(problem1.decideWinner(pobiDrawScore, crongDrawScore)).isEqualTo(0);
        }

        // calculateScore() 테스트
        @Test
        void calculateScoreTest() {
            // 3자리수, 2자리수, 1자리수에 대해 테스트 수행
            List<Integer> hundredsPageNumbers = new ArrayList<>();
            hundredsPageNumbers.add(197);
            hundredsPageNumbers.add(198);

            List<Integer> tensPageNumbers = new ArrayList<>();
            tensPageNumbers.add(55);
            tensPageNumbers.add(56);

            List<Integer> onesPageNumbers = new ArrayList<>();
            onesPageNumbers.add(7);
            onesPageNumbers.add(8);

            int resultOfHundreds = 72;
            int resultOfTens = 30;
            int resultOfOnes = 8;

            Problem1 problem1 = new Problem1();
            assertThat(problem1.calculateScore(hundredsPageNumbers)).isEqualTo(resultOfHundreds);
            assertThat(problem1.calculateScore(tensPageNumbers)).isEqualTo(resultOfTens);
            assertThat(problem1.calculateScore(onesPageNumbers)).isEqualTo(resultOfOnes);
        }

        // makePageMaxNumber(), splitNumbers() 테스트
        @Test
        void makePageMaxNumberTest(){
            // 3자리수, 2자리수, 1자리수에 대해 테스트 수행
            int hundredsPageNumber = 197;
            int tensPageNumber = 56;
            int onesPageNumber = 7;

            // 예상 결과
            int resultOfHundreds = 63;
            int resultOfTens = 30;
            int resultOfOnes = 7;

            Problem1 problem1 = new Problem1();
            assertThat(problem1.makePageMaxNumber(hundredsPageNumber)).isEqualTo(resultOfHundreds);
            assertThat(problem1.makePageMaxNumber(tensPageNumber)).isEqualTo(resultOfTens);
            assertThat(problem1.makePageMaxNumber(onesPageNumber)).isEqualTo(resultOfOnes);
        }

        @Test
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        void case1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem7Test {
        @Test
        void case1() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
