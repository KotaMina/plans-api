package jp.co.plans.apps;

import java.util.Scanner;

public class TagContentExecute {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();

			java.util.List<String> strList = java.util.Arrays.asList(line.split("<"));

			java.util.Set<String> resultSet = new java.util.HashSet<>();
			java.util.Map<String, String> stripMap = new java.util.HashMap<>();
			stripMap.put("Start", "0");
			stripMap.put("End", "1");

			java.util.List<String> startArray = new java.util.ArrayList<>();
			java.util.List<String> endArray = new java.util.ArrayList<>();

			for (int i = 0; i < strList.size(); i++) {
				if (i == 0) {
					continue;
				}

				if (strList.get(i) != "" && !strList.get(i).endsWith(">")) {
					startArray = java.util.Arrays.asList(strList.get(i).split(">"));
					stripMap.put("Start", startArray.get(0));
				}

				if (strList.get(i) != "" && strList.get(i).startsWith("/")) {
					endArray = java.util.Arrays.asList(strList.get(i).split("/"));
					stripMap.put("End", endArray.get(endArray.size() - 1));
				}

				if (stripMap.get("End").startsWith(stripMap.get("Start"))) {
					resultSet.add(startArray.get(startArray.size() - 1));
				}
			}

			for (String r : resultSet) {
				System.out.println(r);
			}

			testCases--;
		}

	}

}
