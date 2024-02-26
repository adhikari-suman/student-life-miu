package lesson7.howmanybehind;

public class PersonLine {
	private Person[] personLine;
	public PersonLine(Person[] persons) {
		personLine = persons;
	}
	public int howManyInLine() {
		return personLine[0].answerToQuestion() + 1;
	}
}
