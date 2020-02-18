package model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

public class Calculations implements ICalculate {
	private String result;

	public String calculate(String txt) {

		txt = txt.replace("/", "/(double)");
		txt = txt.replace(",", ".");
		txt = txt.replace("%", "/(double)100*");

		JShell jshell = JShell.create();
		try (jshell) {
			List<SnippetEvent> event = jshell.eval(txt);
			for (SnippetEvent e : event) {
				if (e.causeSnippet() == null) {
					switch (e.status()) {
					case VALID:
						if (e.value() != null) {
								result = new String(e.value().replace(".", ","));
						}
						break;
					default:
						result = new String("Error\n");
						break;
					}
				}
			}
		}
		return result;
	}

}
