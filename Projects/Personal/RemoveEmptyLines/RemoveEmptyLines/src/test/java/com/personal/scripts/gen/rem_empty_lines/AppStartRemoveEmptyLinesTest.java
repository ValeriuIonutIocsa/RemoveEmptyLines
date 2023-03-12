package com.personal.scripts.gen.rem_empty_lines;

import org.junit.jupiter.api.Test;

class AppStartRemoveEmptyLinesTest {

	@Test
	void testMain() throws Exception {

		final String inputFilePathString;
		final int input = Integer.parseInt("3");
		if (input == 1) {
			inputFilePathString = "F:\\casdev\\td5\\da\\ob1\\410\\DAOB1_000U0_450\\" +
					"work\\tools\\Corema\\Settings\\_FS_DAOB1_0U0_NORMAL\\RuntimeMeas\\T1InstSettings_ORIG.xml";
		} else if (input == 2) {
			inputFilePathString = "F:\\casdev\\td5\\da\\ob1\\410\\DAOB1_000U0_450\\" +
					"work\\tools\\Corema\\Settings\\_FS_DAOB1_0U0_NORMAL\\RuntimeMeas\\T1InstSettings_BIG.xml";
		} else if (input == 3) {
			inputFilePathString = "F:\\casdev\\td5\\da\\ob1\\410\\DAOB1_000U0_450\\" +
					"work\\tools\\Corema\\Settings\\_FS_DAOB1_0U0_NORMAL\\RuntimeMeas\\T1InstSettings_BIGGER.xml";
		} else {
			throw new RuntimeException();
		}

		final String[] args = { inputFilePathString };
		AppStartRemoveEmptyLines.main(args);
	}
}
