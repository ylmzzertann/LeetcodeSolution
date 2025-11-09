import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        backtrack(res, new StringBuilder(), num, target, 0, 0L, 0L);
        return res;
    }

    private void backtrack(List<String> res,
                           StringBuilder path,
                           String num,
                           int target,
                           int pos,
                           long eval,
                           long last) {

        // Tüm karakterleri kullandıysak, sonucu kontrol et
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path.toString());
            }
            return;
        }

        // pos'tan başlayarak farklı uzunlukta sayılar dene
        for (int i = pos; i < num.length(); i++) {
            // Leading zero engeli: "0", "05" gibi; "05" kabul edilmez
            if (i != pos && num.charAt(pos) == '0') break;

            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();

            // İlk sayı: önüne operatör koymayacağız
            if (pos == 0) {
                path.append(curr);
                backtrack(res, path, num, target, i + 1, curr, curr);
                path.setLength(len); // backtrack
            } else {
                // '+'
                path.append('+').append(curr);
                backtrack(res, path, num, target, i + 1, eval + curr, curr);
                path.setLength(len);

                // '-'
                path.append('-').append(curr);
                backtrack(res, path, num, target, i + 1, eval - curr, -curr);
                path.setLength(len);

                // '*'
                path.append('*').append(curr);
                // çarpma için son operandı geri alıp yerine last * curr koy
                long newEval = eval - last + last * curr;
                backtrack(res, path, num, target, i + 1, newEval, last * curr);
                path.setLength(len);
            }
        }
    }
}
