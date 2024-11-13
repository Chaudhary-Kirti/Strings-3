// //stack solution tc- O(n) sc- O(n)

// class Solution {
//     public int calculate(String s) {
//         int n = s.length();
//         Stack<Integer> st = new Stack<>();
//         int currNum = 0;
//         char lastSign = '+';

//         for(int i = 0; i < n; i++){
//             char c = s.charAt(i);
//             if(Character.isDigit(c)){
//                 currNum = currNum * 10 + c - '0';//updating currnum from string
//             }
//             if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){//whenever we encounter operator, we did 
//             //processing accordingly, and then reinitialize currnum to 0 and make lastsign as curr sign
//                  if(lastSign == '+'){
//                     st.push(currNum);
//                  }else if(lastSign == '-'){
//                     st.push(-currNum);
//                  }else if(lastSign == '*'){
//                     int popped = st.pop();
//                     st.push(popped * currNum);
//                  }else if(lastSign == '/'){
//                     int popped = st.pop();
//                     st.push(popped / currNum);
//                  }
//                  currNum = 0;
//                  lastSign = c;
//             }
//         }

//         int result = 0;
//         while(!st.isEmpty()){//process rest of the values left in stack, those will be only addition and substraction
//             result += st.pop();
//         }
//         return result;
//     }
// }


// without stack , reverse multiplication processing with tails solution tc- O(n) sc- O(1)

class Solution {
    public int calculate(String s) {
        int n = s.length();
        int calc = 0;
        int tail = 0;
        int currNum = 0;
        char lastSign = '+';

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';//updating currnum from string
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){//whenever we encounter operator, we did 
            //processing accordingly, and then reinitialize currnum to 0 and make lastsign as curr sign
                 if(lastSign == '+'){
                    calc = calc + currNum;
                    tail = currNum;
                 }else if(lastSign == '-'){
                    calc = calc - currNum;
                    tail = -currNum;
                 }else if(lastSign == '*'){
                    calc = (calc - tail) + (tail * currNum);// first getting the previous currnum to multiple with curr
                    //currnum for that substract tail from calc that was recent calculated value the and curr multiplication
                    tail = tail * currNum;
                 }else if(lastSign == '/'){
                    calc = (calc - tail) + (tail / currNum);
                    tail = tail / currNum;
                 }
                 currNum = 0;
                 lastSign = c;
            }
        }

       
        return calc;
    }
}
