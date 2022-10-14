import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email: emails) {
            String[] split = email.split("@");
            int n = split[0].length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (split[0].charAt(i) == '+') {
                    break;
                } else if (split[0].charAt(i) != '.') {
                    sb.append(split[0].charAt(i));
                }
            }
            sb.append('@');
            sb.append(split[1]);
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {

        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"}));
    }
}
