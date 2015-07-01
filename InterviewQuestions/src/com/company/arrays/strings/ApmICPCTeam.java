package com.company.arrays.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApmICPCTeam {

	public void findMaxTeamAndTopics(List<String> noOfTopics) {

		int numberOfTeams = 1;
		int maxKnow = 0;
		while (!noOfTopics.isEmpty()) {

			String currentTopic = noOfTopics.remove(0);
			for (String topic : noOfTopics) {

				int currentKnow = findTotalTopics(currentTopic, topic);
				if (currentKnow > maxKnow) {
					maxKnow = currentKnow;
				} else if (currentKnow == maxKnow) {
					numberOfTeams += 1;
				}

			}
		}

		System.out.println(maxKnow);
		System.out.println(numberOfTeams);

	}

	public int findTotalTopics(String topic1, String topic2) {
		int totalTopic = 0;
		char[] topic_1 = topic1.toCharArray();
		char[] topic_2 = topic2.toCharArray();

		for (int i = 0; i < topic_1.length || i < topic_2.length; i++) {

			if (topic_1[i] == '1' || topic_2[i] == '1') {
				totalTopic += 1;
			}
		}

		return totalTopic;

	}

	public static void main(String[] args) {

	    final Scanner scan = new Scanner(System.in);
			int numberOfTopics = Integer.parseInt(scan.nextLine());
			int totalTopic = Integer.parseInt(scan.nextLine());
			List<String> noOfTopics = new ArrayList<String>(numberOfTopics);
			while (scan.hasNextLine()) {
				String topic = scan.nextLine();
				noOfTopics.add(topic);
			}
		ApmICPCTeam soln = new ApmICPCTeam();
		soln.findMaxTeamAndTopics(noOfTopics);
	}

}
