import java.util.Arrays;
import java.util.Stack;

public class NGR {
    public static int[] ngr(int[] arr) {
        int[] ans = new int[arr.length];
        int p = arr.length - 1;
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[p--] = -1;
            } else {
                ans[p--] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(ngr(arr)));
    }
}
