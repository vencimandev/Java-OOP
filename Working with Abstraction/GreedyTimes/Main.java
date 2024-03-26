package GreedyTimes;


    import java.util.Collection;
    import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] vaultContents = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long goldAmount = 0;
        long gemAmount = 0;
        long cashAmount = 0;

        for (int i = 0; i < vaultContents.length; i += 2) {
            String itemName = vaultContents[i];
            long quantity = Long.parseLong(vaultContents[i + 1]);

            String itemType = determineItemType(itemName);

            if (itemType.equals("")) {
                continue;
            } else if (!canAddItem(bag, itemType, quantity, bagCapacity)) {
                continue;
            }

            if (!bag.containsKey(itemType)) {
                bag.put(itemType, new LinkedHashMap<>());
            }

            bag.get(itemType).merge(itemName, quantity, Long::sum);

            if (itemType.equals("Gold")) {
                goldAmount += quantity;
            } else if (itemType.equals("Gem")) {
                gemAmount += quantity;
            } else if (itemType.equals("Cash")) {
                cashAmount += quantity;
            }
        }

        printCollectedItems(bag);
    }

    private static String determineItemType(String itemName) {
        if (itemName.length() == 3) {
            return "Cash";
        } else if (itemName.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (itemName.equalsIgnoreCase("gold")) {
            return "Gold";
        }
        return "";
    }

    private static boolean canAddItem(Map<String, LinkedHashMap<String, Long>> bag, String itemType, long quantity, long bagCapacity) {
        if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity) {
            return false;
        }

        switch (itemType) {
            case "Gem":
                if (!hasEnoughGold(bag, quantity)) return false;
                break;
            case "Cash":
                if (!hasEnoughGems(bag, quantity)) return false;
                break;
        }

        return true;
    }

    private static boolean hasEnoughGold(Map<String, LinkedHashMap<String, Long>> bag, long quantity) {
        return bag.containsKey("Gold") && quantity <= getTotalAmount(bag, "Gold");
    }

    private static boolean hasEnoughGems(Map<String, LinkedHashMap<String, Long>> bag, long quantity) {
        return bag.containsKey("Gem") && quantity <= getTotalAmount(bag, "Gem");
    }

    private static long getTotalAmount(Map<String, LinkedHashMap<String, Long>> bag, String type) {
        return bag.getOrDefault(type, new LinkedHashMap<>()).values().stream().mapToLong(Long::longValue).sum();
    }

    private static void printCollectedItems(LinkedHashMap<String, LinkedHashMap<String, Long>> bag) {
        bag.forEach((type, items) -> {
            long sumValues = items.values().stream().mapToLong(l -> l).sum();
            System.out.println(String.format("<%s> $%s", type, sumValues));
            items.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByKey().reversed())
                    .forEach(item -> System.out.println("##" + item.getKey() + " - " + item.getValue()));
        });
    }
}
