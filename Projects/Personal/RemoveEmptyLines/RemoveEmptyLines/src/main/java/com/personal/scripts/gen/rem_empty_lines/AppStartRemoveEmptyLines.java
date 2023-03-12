package com.personal.scripts.gen.rem_empty_lines;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

final class AppStartRemoveEmptyLines {

	private AppStartRemoveEmptyLines() {
	}

	public static void main(
			final String[] args) throws Exception {

		if (args.length == 0) {

			final String helpMessage = createHelpMessage();
			System.err.println("insufficient arguments" + System.lineSeparator() + helpMessage);
			System.exit(-1);
		}

		if ("--help".equals(args[0])) {

			final String helpMessage = createHelpMessage();
			System.out.println(helpMessage);
			System.exit(0);
		}

		final String inputFilePathString = args[0];
		final Path inputFilePath = Paths.get(inputFilePathString);

		final String outputFilePathString = computeOutputFilePathString(inputFilePathString);
		final Path outputFilePath = Paths.get(outputFilePathString);

		try (BufferedReader bufferedReader = Files.newBufferedReader(inputFilePath);
				PrintStream printStream = new PrintStream(
						new BufferedOutputStream(Files.newOutputStream(outputFilePath)))) {

			String line;
			while ((line = bufferedReader.readLine()) != null) {

				if (!line.isBlank()) {
					printStream.println(line);
				}
			}
		}
	}

	private static String createHelpMessage() {

		return "usage: remove_empty_lines INPUT_PATH";
	}

	private static String computeOutputFilePathString(
			final String inputFilePathString) {

		final int lastIndexOf = inputFilePathString.lastIndexOf('.');
		return inputFilePathString.substring(0, lastIndexOf) + "_NO_BLANK_LINES" +
				inputFilePathString.substring(lastIndexOf);
	}
}
