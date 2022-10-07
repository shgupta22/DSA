import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

    public EncodeDecodeString(){

    }

    public String encode(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            int length = s.length();
            sb.append(length);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < str.length();) {
            StringBuilder sb = new StringBuilder();
            while (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
                i++;
            }
            int length = Integer.parseInt(sb.toString());
            String substring = str.substring(i + 1, i + 1 + length);
            res.add(substring);
            i = i + 1+length;
        }

        return res;
    }

    public static void main(String[] args) {
        EncodeDecodeString encodeDecodeString = new EncodeDecodeString();

        String encode = encodeDecodeString.encode(new String[]{"leet", "code", "apple", "banana"});
        System.out.println(encode);
        System.out.println(encodeDecodeString.decode(encode));
    }
}
