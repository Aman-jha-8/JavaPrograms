import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        List<Integer> lint = np.nextper(6,new int[]{6,9,8,7,5,4});
        Integer[] intarr = lint.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(intarr));
    }

    public List<Integer> nextper(int N, int[] arr){
        List<Integer> result = new ArrayList<>();

        int i=N-2;
        while(i>=0 && arr[i] >= arr[i+1]){
            i--;
        }

        if(i>=0){
            int j= N-1;

            while(j>=0 && arr[j] < arr[i]){
                j--;
            }

            swap(arr, i, j);
        }

        reverse(arr, i + 1, N-1);

        result = Arrays.stream(arr).boxed().collect(Collectors.toList());

        return result;
    }

    private void swap(int[] arr,int num1 , int num2){
        arr[num1] = arr[num1] ^ arr[num2];
        arr[num2] = arr[num1] ^ arr[num2];
        arr[num1] = arr[num1] ^ arr[num2];
    }

    private void reverse(int[] arr,int i,int j){
        int b=j;
        for(int a=i;a<b;a++){
            swap(arr, a, b--);
        }
    }
}
