class Solution {
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        int len = date.length();

        // 1. Adım: Yıl (Her zaman son 4 karakterdir)
        sb.append(date.substring(len - 4));
        sb.append('-');

        // 2. Adım: Ay (Yıldan önceki boşluğu atlayıp, 3 harfli ayı alırız)
        // Ay her zaman sondan 8. karakter ile 5. karakter arasındadır.
        String monthStr = date.substring(len - 8, len - 5);
        sb.append(getMonth(monthStr));
        sb.append('-');

        // 3. Adım: Gün
        // Eğer tarih 13 karakterse gün 2 hanelidir (örn: "20th Oct 2052")
        // Eğer tarih 12 karakterse gün 1 hanelidir (örn: "6th Jun 1933")
        if (len == 13) {
            sb.append(date.substring(0, 2));
        } else {
            sb.append('0').append(date.charAt(0));
        }

        return sb.toString();
    }

    // Switch-case, HashMap'ten çok daha hızlı çalışır
    private String getMonth(String month) {
        switch (month) {
            case "Jan": return "01";
            case "Feb": return "02";
            case "Mar": return "03";
            case "Apr": return "04";
            case "May": return "05";
            case "Jun": return "06";
            case "Jul": return "07";
            case "Aug": return "08";
            case "Sep": return "09";
            case "Oct": return "10";
            case "Nov": return "11";
            case "Dec": return "12";
            default: return "";
        }
    }
}