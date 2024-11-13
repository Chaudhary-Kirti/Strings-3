//tc- O(1) sc-O(1)

class Solution {
    String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
    String[] below20 = {" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"","", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        String result = "";
        if(num == 0) return "Zero";
        int i =0;
        while(num > 0){
            int triplet = num %1000;//sending triplet from left
            if(triplet > 0){
                result = helper(triplet).trim() + " " + thousands[i] + " " + result;//adding thousands value according to i
            }
            i++;
            num = num/1000;
        }
        return result.trim();
        
    }
    private String helper(int num){
        if(num < 20){
            return below20[num];
        }else if(num < 100){
            return tens[num/10] + " " + below20[num%10];//for ex 98, 65 below 100
        }else{
            return below20[num/100] + " Hundred " + helper(num%100);//for one chunk of 123 also calling helper again for 23
        }
    }
}