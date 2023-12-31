import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindPermutation{
	public static void main(String[] args) {
        FindPermutation fp = new FindPermutation();
        List<String> lst = fp.find_permutation("Aman");
        String[] saar = lst.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(saar));

	}

	public List<String> find_permutation(String s){
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
        List<String> permutations = new ArrayList<>();
        backtrack(permutations, chars, new boolean[chars.length], new StringBuilder(""));
        return permutations;
	}

    private void backtrack(List<String> permutations,char[] chars, boolean[] used, StringBuilder current){
        // now the Base Case...
        if(current.length() == chars.length){
            permutations.add(current.toString());
        }

        // General case...

        for(int i=0;i< chars.length;i++){
            if(used[i] || ( i> 0 &&
                chars[i] == chars[i-1] && !used[i-1]
            )){
                continue;
            }

            used[i]=true;
            current.append(chars[i]);
            backtrack(permutations, chars, used, current);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }

    }
}
