import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reformatDate(String date) {
        // Step 1: Split the date string by space
        String[] parts = date.split(" ");
        String dayRaw = parts[0];
        String monthRaw = parts[1];
        String year = parts[2];

        // Step 2: Create a map for month conversion
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01"); monthMap.put("Feb", "02"); monthMap.put("Mar", "03");
        monthMap.put("Apr", "04"); monthMap.put("May", "05"); monthMap.put("Jun", "06");
        monthMap.put("Jul", "07"); monthMap.put("Aug", "08"); monthMap.put("Sep", "09");
        monthMap.put("Oct", "10"); monthMap.put("Nov", "11"); monthMap.put("Dec", "12");
        
        String month = monthMap.get(monthRaw);

        // Step 3: Format the day
        // Remove the last 2 characters (st, nd, rd, th)
        String day = dayRaw.substring(0, dayRaw.length() - 2);
        
        // Add leading zero if single digit
        if (day.length() == 1) {
            day = "0" + day;
        }

        // Step 4: Return formatted string
        return year + "-" + month + "-" + day;
    }
}