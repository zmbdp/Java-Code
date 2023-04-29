import java.util.*;
public class Solution {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] A = {1,2,3,0,0,0};
        int[] B = {4,5,6};
        int i = ((m + n) - 1);
        int b = (B.length - 1);
        int a = (A.length - 1);
        while ((a >= 0) && (b >= 0) && (i >= 0)) {
            if (A[a] > B[b]) {
                A[i--] = A[a--];
            }
            else if (A[a] < B[b]) {
                A[i--] = B[b--];
            }
            else {
                A[i--] = A[a--];
                A[i] = B[b--];
            }
        }
        if (b >= 0) {
            for (; i >= 0; i--) {
                A[i] = B[b--];
            }
        }
    }
}