class Solution {
    public double averageWaitingTime(int[][] customers) {
        double time = 0;
        double wholewaittime = 0;
        for(int[] x: customers){
            if(time < x[0]){
                time = x[0];
            }else{
                wholewaittime = wholewaittime + time - x[0];
            }
            time += x[1];
            wholewaittime += x[1];
        }
        return wholewaittime / customers.length;
    }
}