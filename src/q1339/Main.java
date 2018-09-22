package q1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	static String[] input;
	static int k;
	static HashMap<Character, Long> hm = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int num_alphabet, i;
		long arr[], sum = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		input = new String[k];

		for (i = 0; i < k; i++) {
			input[i] = "";
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);
				input[i] += ch;
				if (!hm.containsKey(ch))
					hm.put(ch, (long) Math.pow(10, line.length() - j - 1));
				else {
					hm.put(ch, (long) (hm.get(ch) + Math.pow(10, line.length() - j - 1)));
				}
			}
		}

		num_alphabet = hm.size();
		arr = new long[num_alphabet];
		i = 0;
		for (Character ch : hm.keySet()) {
			arr[i] = hm.get(ch);
			i++;
		}

		Arrays.sort(arr);

		for (i = 0; i < num_alphabet; i++) {
			sum += arr[i] * (9 - num_alphabet + 1  + i);
		}
		System.out.println(sum);
	}
}
