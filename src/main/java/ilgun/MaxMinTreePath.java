package ilgun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class MaxMinTreePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int counter = 1;

		File f = new File("temp.txt");

		try {
			FileInputStream in = new FileInputStream(f);

			String result = new BufferedReader(new InputStreamReader(in)).lines().parallel()
					.collect(Collectors.joining("\n"));

			int size = (int) result.lines().count();

			int[][] triangle = new int[size][size];

			String[] expected = result.split("\\s+");

			int count = 0;

			int len = expected.length;

			for (int i = 0; i < size; ++i) {

				for (int j = 0; j <= i; ++j) {

					triangle[i][j] = Integer.parseInt(expected[count]);
					++count;
				}
			}
//If you want to see matrix form of numbers , you can uncomment here
			/*
			for (int i = 0; i < size; ++i) {

				for (int j = 0; j < size; ++j) {

					System.out.print(triangle[i][j] + " ");
				}
				System.out.println("");
			}*/

			int answer = minpath(triangle, size);
			
			System.out.print("Min path value, among of all given paths, is :"  + answer);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static int minpath(int input[][], int n) {

		for (int i = n - 2; i >= 0; i--) {
			
			for (int j = 0; j <= i; j++) {
				
				if (input[i + 1][j] < input[i + 1][j + 1])
					input[i][j] += input[i + 1][j];
				else
					input[i][j] += input[i + 1][j + 1];
			}
		}
		return input[0][0];
	}

}