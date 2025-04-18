class Solution {
    public String multiply(String num1, String num2) {
        // Eğer biri 0 ise sonuç direkt "0" olur
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n]; // en fazla m + n basamak olabilir

        // Ters sırayla çarpma işlemi
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';

                int mul = digit1 * digit2;
                int sum = mul + result[i + j + 1]; // Önceki kalanla topla

                result[i + j + 1] = sum % 10;             // basamak
                result[i + j] += sum / 10;                // elde
            }
        }

        // Sonucu string'e çevirme
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // Başta gelen sıfırları atla
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}