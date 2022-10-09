import java.util.*;

public class AccountMerge {

    //INCOMPLETE ****
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, TreeSet<String>> map = new HashMap<>();

        for (List<String> accDetails: accounts) {
            String name = accDetails.get(0);
            for (int i = 1; i < accDetails.size(); i++) {
                if (!map.containsKey(accDetails.get(i))) map.put(accDetails.get(i), new TreeSet<>());
                map.get(accDetails.get(i)).addAll(accDetails);
            }
        }

        List<List<String>> result = new ArrayList<>();

        return null;

    }

    public static void main(String[] args) {

    }
}
