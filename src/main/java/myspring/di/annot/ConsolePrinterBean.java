package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinterBean implements PrinterBean {
	public void print(String message) {
		System.out.println(message);
	}
}
