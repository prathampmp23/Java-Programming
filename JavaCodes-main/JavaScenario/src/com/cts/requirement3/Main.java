package com.cts.requirement3;

import java.util.Scanner;

public class Main {

	static Boolean validateRefld(String refld) {

		if (!refld.contains(" ") || refld.indexOf(' ') != refld.lastIndexOf(' '))
			return false;

		String codes[] = refld.split(" ");
		if (codes.length != 2)
			return false;

		String code1[] = codes[0].split("-");
		String code2[] = codes[1].split("-");
		if (code1.length != 2 || code2.length != 2)
			return false;

		String DCC = code1[0];
		String VC1 = code1[1];

		String ACC = code2[0];
		String VC2;
		String ticketNo = null;

		if (code2[1].contains("/")) {
			String initVC2[] = code2[1].split("/");
			if (initVC2.length != 2)
				return false;

			VC2 = initVC2[0];
			ticketNo = initVC2[1];
		} else {
			VC2 = code2[1];
		}

		if (DCC.length() < 2 || DCC.length() > 4)
			return false;
		if (ACC.length() < 2 || ACC.length() > 4)
			return false;
		if (VC1.length() < 3 || VC1.length() > 4)
			return false;
		if (VC2.length() < 3 || VC2.length() > 4)
			return false;

		for (int i = 0; i < DCC.length(); i++) {
			if (DCC.charAt(i) < 'A' || DCC.charAt(i) > 'Z')
				return false;
		}
		for (int i = 0; i < ACC.length(); i++) {
			if (ACC.charAt(i) < 'A' || ACC.charAt(i) > 'Z')
				return false;
		}
		for (int i = 0; i < VC1.length(); i++) {
			if (!Character.isLetterOrDigit(VC1.charAt(i)))
				return false;
		}
		for (int i = 0; i < VC2.length(); i++) {
			if (!Character.isLetterOrDigit(VC2.charAt(i)))
				return false;
		}

		if (ticketNo != null) {
			if (ticketNo.length() != 3)
				return false;

			if (ticketNo.charAt(0) != 'U' && ticketNo.charAt(0) != 'L' && ticketNo.charAt(0) != 'W'
					&& ticketNo.charAt(0) != 'S')
				return false;

			if (!Character.isDigit(ticketNo.charAt(1)) || !Character.isDigit(ticketNo.charAt(2)))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the RefId to be validated: ");
		String refId = sc.nextLine();
		if (Main.validateRefld(refId)) {
			System.out.println("RefId is valid");
		} else {
			System.out.println("RefId is invalid");
		}
		sc.close();
	}
}