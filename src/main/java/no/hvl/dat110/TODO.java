package no.hvl.dat110;

/**
 * En klasse de har brukt for å lage feilmeldinger når kode ikke er skrevet
 */
public class TODO {

	/**
	 * @return
	 */
	public static String method() {

		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

		return "Metoden " + methodName + " er ikke implementert";
	}

	/**
	 * @param className
	 * @return
	 */
	public static String constructor(String className) {

		return "Konstruktøren for klassen " + className + " er ikke implementert";

	}

}
