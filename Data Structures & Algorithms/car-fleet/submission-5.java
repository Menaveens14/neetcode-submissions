class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
       int[][] arr = new int[position.length][2];

       for(int i = 0; i < position.length; i++){
        arr[i][0] = position[i];
        arr[i][1] = speed[i];

       }

        Stack<Double> stack = new Stack<>();

       Arrays.sort(arr, (a, b) ->  b[0] - a[0] );
            
       for(int i = 0; i < position.length; i++){

        
        double time = (double)(target - arr[i][0]) / arr[i][1];

        if(stack.empty() || stack.peek() < time)
            stack.push(time);

       }


    return stack.size();
    }
}
