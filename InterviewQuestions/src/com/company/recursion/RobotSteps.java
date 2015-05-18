package com.company.recursion;

/**
 * Find out number of ways to travers from (0,0) to (X,y)
 * The total number of calls : (X+Y)!/X!Y!
 * @author rohitdumbre86
 *
 */
public class RobotSteps {

	public static int Xdest = 3;
	public static int Ydest = 3;
	public static int numberOfWays = 0;
	public static int DPcalls = 0;
	public static int recurCalls = 0;

	public int functionDP(int Xorg, int Yorg, int[][] arrs) {

		if (Xorg == Xdest && Yorg == Ydest) {
			return 1;
		}

		if (Yorg > Ydest || Xorg > Xdest) {
			return 0;
		}

		if (arrs[Xorg][Yorg] > 0)
			return arrs[Xorg][Yorg];

		DPcalls++;

		return (arrs[Xorg][Yorg] = functionDP(Xorg, Yorg + 1, arrs)
				+ functionDP(Xorg + 1, Yorg, arrs));
	}

	public int functionJustRecursive(int Xorg, int Yorg) {

		if (Xorg == Xdest && Yorg == Ydest) {
			return 1;
		}

		if (Yorg > Ydest || Xorg > Xdest) {
			return 0;
		}
		recurCalls++;

		return (functionJustRecursive(Xorg, Yorg + 1) + functionJustRecursive(
				Xorg + 1, Yorg));
	}

	public static void main(String[] args) {
		RobotSteps steps = new RobotSteps();
		System.out.println("Dynamic Programming :"
				+ steps.functionDP(0, 0, new int[Xdest + 1][Ydest + 1]));
		System.out.println("Recurion :" + steps.functionJustRecursive(0, 0));
		System.out.println("Dynamic Programming calls :" + DPcalls);
		System.out.println("Recursive Programming calls :" + recurCalls);
	}

}
