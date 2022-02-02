class Solution {
    public String reversePrefix(String word, char ch) {
        int index = getIndex(word, ch);
        String str = "";
        for(int i = index; i >= 0; i--){
            str += word.charAt(i);
        }
        for(int i = index + 1; i < word.length(); i++){
            str += word.charAt(i);
        }
        return str;
    }
    private int getIndex(String word, char ch){
        int temp = -1;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ch){
                temp = i;
                break;
            }
        }
        return temp;
    }
}