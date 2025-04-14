import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Açılış parantezlerini stack'e ekle
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // Stack boşsa ve kapama parantezi geldiyse false döner
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Eşleşmiyorsa false
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Stack boşsa tüm parantezler düzgün kapanmıştır
        return stack.isEmpty();
    }
}
