class Solution {
    public int totalNumbers(int[] digits) {
        // Step 1: Build the "inventory" of your available digits
        int[] inventory = new int[10];
        for (int d : digits) {
            inventory[d]++;
        }
        
        int validCount = 0; // Just count them instead of storing them
        
        // Step 2: Loop the answer space (100 to 998, stepping by 2)
        for (int num = 100; num < 1000; num += 2) {
            
            // Step 3: Break down the target number into required digits
            int[] required = new int[10];
            required[num / 100]++;          // Hundreds digit
            required[(num / 10) % 10]++;    // Tens digit
            required[num % 10]++;           // Ones digit
            
            // Step 4: Check if we have enough ingredients
            boolean canBuild = true;
            for (int i = 0; i < 10; i++) {
                if (required[i] > inventory[i]) {
                    canBuild = false;
                    break;
                }
            }
            
            // Step 5: Increment count if valid
            if (canBuild) {
                validCount++;
            }
        }
        
        return validCount;
    }
}