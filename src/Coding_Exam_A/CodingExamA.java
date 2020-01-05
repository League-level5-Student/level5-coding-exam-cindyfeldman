package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	private static int robots;
	private static String color;
	private static int sides;
	Color getColor() {
		if(color.equalsIgnoreCase("Red")) {
			return Color.red;
		}
		else if(color.equalsIgnoreCase("Green")){
			return Color.green;
		}
		else if(color.equalsIgnoreCase("Blue")) {
			return Color.blue;
		}
		return Color.black;
	}
	public static void main(String[] args) {
		
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		robots = Integer.valueOf(JOptionPane.showInputDialog("How many Robots?"));
		color = JOptionPane.showInputDialog("What color: Red, Green, Blue?");
		sides = Integer.valueOf(JOptionPane.showInputDialog("how many sides (>0)"));
		CodingExamA c = new CodingExamA();
		for (int i = 0; i < robots; i++) {
			Robot r = new Robot(300*i,300);
			r.setSpeed(10);
			Thread t = new Thread(()-> {
				r.setPenColor(c.getColor());
				r.penDown();
				int angle = 360/sides;
				for (int j = 0; j < 360; j+=angle) {
					r.move(50);
					r.turn(angle);
				}
			});
			t.start();
		}
	}
}
