import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Match {

	private static final String FILE_NAME = "FullRoster.txt";

	public static void main(String[] args) {

		LineNumberReader lineReader = null;
		int numStudents = 0;
		try {
			lineReader = new LineNumberReader(new FileReader(FILE_NAME));
			// obtain number of students in text file
			// as opposed to initializing a large array with unused entries
			numStudents = GetNumberOfLinesInFile(lineReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Student[] students = new Student[numStudents];

		String line = "";
		int studentArrayPosition = 0;
		int preferencesInitparameters[];
		String studentInitParameters[];

		try {
			// close and re-initialize line reader. wouldnt work otherwise
			lineReader.close();
			lineReader = new LineNumberReader(new FileReader(FILE_NAME));
			// while file has another line, keep reading
			while ((line = lineReader.readLine()) != null) {
				// split line on tabs, to extract student parameters
				studentInitParameters = line.split("\t", -1);
				// this will hold the parsed parameters to initialize new student
				preferencesInitparameters = new int[4];
				preferencesInitparameters[0] = Integer
						.parseInt(studentInitParameters[3]);
				preferencesInitparameters[1] = Integer
						.parseInt(studentInitParameters[4]);
				preferencesInitparameters[2] = Integer
						.parseInt(studentInitParameters[5]);
				preferencesInitparameters[3] = Integer
						.parseInt(studentInitParameters[6]);
				students[studentArrayPosition] = new Student(
						studentInitParameters[0],
						studentInitParameters[1].charAt(0),
						// init date from string instead of parsing ints here
						Date.InitDateFromString(studentInitParameters[2]),
						// init student preferences using an array of values, to reduce clutter 
						Preference
								.InitPreferenceFromArray(preferencesInitparameters),
						false);
				studentArrayPosition++;
			}
			// release file
			lineReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// compare students based on algorithm found on the assignment
		for (int i = 0; i < students.length; i++) {
			// if student is already matched, no need to run loop
			if (students[i].getMatch())	continue;
			Student match = null;
			for (int j = i + 1; j < students.length; j++) {
				// if possible student match has a match status of false and the score is good, then set match
				if (!students[j].getMatch()
						&& (students[i].compare(students[j]) > 0)
						&& (match == null || students[i].compare(students[j]) > students[i].compare(match))) {
					// set match
					match = students[j];
				}
			}
			// if match is not null, print information
			if (match != null) {
				PrintText(students[i].getName() + " matches with "
						+ match.getName() + " with the score "
						+ students[i].compare(match));
				students[i].setMatch(true);
				match.setMatch(true);
				// match is null, which means the student does not have a match
			} else {
				PrintText(students[i].getName() + " had no matches.");
			}
		}

	}

	static int GetNumberOfLinesInFile(LineNumberReader lineReader) {
		int numLinesInFile = 0;
		try {
			// set line position to a large value. this will set the file line position to the last line
			lineReader.skip(Long.MAX_VALUE);
			numLinesInFile = lineReader.getLineNumber() + 1;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return numLinesInFile;
	}

	static void PrintText(String text) {
		System.out.println(text);
	}
}
