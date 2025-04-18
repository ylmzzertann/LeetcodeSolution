class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();

        for (int i = m - 1; i >= 0; i--) {
            int d1 = a[i] - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = b[j] - '0';
                int mul = d1 * d2;
                int sum = mul + res[i + j + 1];

                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        // İlk sıfırları atla
        int start = 0;
        while (start < res.length && res[start] == 0) {
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < res.length; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
