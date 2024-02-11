import java.util.*;

/**
 *
 */
public class Solution {
    private Solution() {
    }

    static Solution createSolution() {
        return new Solution();
    }

    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> giftCounts = new HashMap<>();
        Map<String, Integer> giftGivers = new HashMap<>();

        for (String friend : friends) {
            giftCounts.put(friend, 0);
            giftGivers.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String giver = split[0];
            String receiver = split[1];

            if (!giver.equals(receiver)) {
                giftCounts.put(receiver, giftCounts.get(receiver) + 1);
                giftCounts.put(giver, giftCounts.get(giver) - 1);
                giftGivers.put(receiver, giftGivers.get(receiver) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedCounts = new ArrayList<>(giftCounts.entrySet());
        sortedCounts.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            } else {
                return giftGivers.get(b.getKey()) - giftGivers.get(a.getKey());
            }
        });

        int maxGifts = sortedCounts.get(0).getValue();
        int maxGiftReceivers = 0;

        for (Map.Entry<String, Integer> entry : sortedCounts) {
            if (entry.getValue() == maxGifts) {
                maxGiftReceivers++;
            }
        }

        return maxGiftReceivers > 1 ? maxGifts : maxGifts + 1;
    }
}