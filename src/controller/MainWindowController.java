package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Calculations;
import model.ICalculate;

public class MainWindowController {

	@FXML
	Button bAC, bPlusMinus, bPercent, bDivide, bMultiply, bMinus, bPlus, bEquals;
	@FXML
	Button bComma, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	@FXML
	TextField taResult;
	@FXML
	Pane splitPane;

	ICalculate calc = new Calculations();

	public void setCalc(ICalculate calc) {
		this.calc = calc;
	}

	@FXML
	public void clearBoard() {
		taResult.setText("");
	}

	@FXML
	public void handleButtons(ActionEvent e) {

		String txt = taResult.getText();
		String input = ((Button) e.getSource()).getText();

		switch (input) {
		case "AC":
			clearBoard();
			break;
		case "=":
			taResult.setText(calc.calculate(txt));
			break;
		case "+/-":
			if (txt.startsWith("-", 0)) {
				txt = txt.replaceFirst("-", "");
				taResult.setText(txt);
			} else {
				taResult.setText("-" + txt);
			}
			break;
		default:
			StringBuilder sB = new StringBuilder();
			sB.append(txt);
			sB.append(input);
			taResult.setText(sB.toString());
			break;

		}
	}

}
