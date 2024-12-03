package collection.compare.test;

import java.util.*;

public class CardGameMain {

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.shuffle();

        Player 플레이어1 = new Player(deck.drawCards(), "플레이어1");
        Player 플레이어2 = new Player(deck.drawCards(), "플레이어2");

        Deck.Evaluator evaluator = deck.new Evaluator();
        evaluator.handEvaluator(플레이어1, 플레이어2);
    }

    static class Player {
        private final List<String> hands;
        private final String nickName;

        public Player(List<String> hands, String nickName) {
            this.hands = hands;
            this.nickName = nickName;
        }

        public List<String> getHands() {
            return hands;
        }

        public String getNickName() {
            return nickName;
        }
    }

    static class Deck {
        private final List<String> decks = new ArrayList<>();
        private final Map<Integer, String> patterns = Map.of(0, "\u2660", 1, "\u2665", 2, "\u2666", 3, "\u2663");
        private int cardCount = 14;
        private int playerhands = 5;
        private Iterator<String> deckIterator;

        public Deck() {
            for (Integer pattern : patterns.keySet()) {
                for (int i = 1; i < cardCount; i++) {
                    decks.add(i + " " + pattern);
                }
            }
        }

        public Deck(int cardCount, int playerhands) {
            this();
            this.cardCount = cardCount;
            this.playerhands = playerhands;
        }

        public void shuffle() {
            Collections.shuffle(decks);
            deckIterator = decks.iterator();
        }

        public List<String> drawCards() {
            String[] hands = new String[playerhands];
            int index = 0;
            while (deckIterator.hasNext()) {
                hands[index++] = deckIterator.next();
                if (index == playerhands) break;
            }

            if (hands.length != playerhands) {
                return null;
            }

            List<String> resultHands = Arrays.asList(hands);
            resultHands.sort(new CardGameComparator());
            return Collections.unmodifiableList(resultHands);
        }

        class Evaluator {

            public void handEvaluator(Player player1, Player player2) {

                int totalScore1 = calculation(player1);
                int totalScore2 = calculation(player2);

                if (totalScore1 > totalScore2) {
                    System.out.println(player1.getNickName() + " 승리");
                } else if (totalScore1 == totalScore2) {
                    System.out.println("무승부");
                } else {
                    System.out.println(player2.getNickName() + " 승리");
                }

            }

            private int calculation(Player player) {
                int sumPlayer = 0;
                System.out.print(player.getNickName() + "의 카드: [");
                List<String> hands = player.getHands();
                for (int i = 0; i < hands.size(); i++) {
                    String[] hands1 = hands.get(i).split(" ");
                    int number1 = Integer.parseInt(hands1[0]);
                    int pattern1 = Integer.parseInt(hands1[1]);
                    sumPlayer += number1;

                    System.out.print(number1 + "(" + patterns.get(pattern1) + ")");

                    if (playerhands - 1 > i) System.out.print(", ");
                }
                System.out.print("], 합계: " + sumPlayer);

                System.out.println();
                return sumPlayer;
            }

        }
    }

    static class CardGameComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String[] hands1 = o1.split(" ");
            int number1 = Integer.parseInt(hands1[0]);
            int pattern1 = Integer.parseInt(hands1[1]);

            String[] hands2 = o2.split(" ");
            int number2 = Integer.parseInt(hands2[0]);
            int pattern2 = Integer.parseInt(hands2[1]);

            if (number1 == number2) {
                return Integer.compare(pattern1, pattern2);
            } else {
                return Integer.compare(number1, number2);
            }
        }
    }


}
